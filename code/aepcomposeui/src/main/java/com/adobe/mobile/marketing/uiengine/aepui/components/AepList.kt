package com.adobe.mobile.marketing.uiengine.aepui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adobe.mobile.marketing.uiengine.aepui.AepUI
import com.adobe.mobile.marketing.uiengine.aepui.LargeImageAepUi
import com.adobe.mobile.marketing.uiengine.aepui.SmallImageAepUi
import com.adobe.mobile.marketing.uiengine.contentprovider.AepUiContentProvider
import com.adobe.mobile.marketing.uiengine.observers.AepUiEventObserver
import com.adobe.mobile.marketing.uiengine.aepui.state.LargeImageUIState
import com.adobe.mobile.marketing.uiengine.aepui.state.SmallImageUIState
import com.adobe.mobile.marketing.uiengine.aepui.style.AepUiStyle
import com.adobe.mobile.marketing.uitemplates.LargeImageTemplate
import com.adobe.mobile.marketing.uitemplates.SmallImageTemplate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Composable for rendering a list of AEP UI components.
 * Maintains a list of AEP UI components and renders them using the provided container.
 */
@Composable
fun AepList(
    contentProvider: AepUiContentProvider,
    aepUiEventObserver: AepUiEventObserver,
    aepUiStyle: AepUiStyle,
    viewModelKey: String,
    container: @Composable (@Composable () -> Unit) -> Unit = { content ->
        // Default to a Column if no container is provided
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                content()
            }
        }
    }
) {
    val viewModel: AepListViewModel = viewModel(
        factory = AepComposableViewModelFactory(
            contentProvider
        ),
        key = viewModelKey
    )
    val uiList = viewModel.uiList.collectAsStateWithLifecycle()

    container {
        uiList.value.forEach { ui ->
            val uiAsComposable = asComposable(ui, aepUiEventObserver, aepUiStyle)
            uiAsComposable.invoke()
        }

        Button(onClick = { viewModel.loadMore() }, Modifier.fillMaxWidth()) {
            Text(text = "Load More")
        }
    }
}


private fun asComposable(
    aepUI: AepUI<*, *>,
    observer: AepUiEventObserver,
    aepUiStyle: AepUiStyle
): @Composable () -> Unit {
    return when (aepUI) {
        is LargeImageAepUi -> {
            {
                val state = aepUI.getState()
                if (!state.dismissed) {
                    LargeImageCard(
                        ui = aepUI,
                        style = aepUiStyle.largeImageAepUiStyle,
                        observer = observer
                    )
                }
            }
        }

        is SmallImageAepUi -> {
            {
                val state = aepUI.getState()
                if (!state.dismissed) {
                    SmallImageCard(
                        ui = aepUI,
                        style = aepUiStyle.smallImageAepUiStyle,
                        observer = observer
                    )
                }
            }
        }

        else -> throw IllegalArgumentException("Unknown template type")
    }
}


private class AepListViewModel(
    private val contentProvider: AepUiContentProvider,
) : ViewModel() {

    private val _uiList = MutableStateFlow(listOf<AepUI<*, *>>())
    val uiList: StateFlow<List<AepUI<*, *>>> = _uiList

    init {
        viewModelScope.launch {
            contentProvider.getContent().collect { templates ->

                val uiList = templates.map { template ->

                    val aepUiState: AepUI<*, *> = when (template) {
                        is LargeImageTemplate -> LargeImageAepUi(
                            template,
                            LargeImageUIState()
                        )

                        is SmallImageTemplate -> SmallImageAepUi(
                            template,
                            SmallImageUIState(title = template.title?.content)
                        )

                        else -> throw IllegalArgumentException("Unknown template type")
                    }

                    aepUiState
                }
                _uiList.value = uiList
            }
        }
    }

    fun loadMore() {
        viewModelScope.launch {
            contentProvider.refreshContent()
        }
    }
}

private class AepComposableViewModelFactory(
    private val contentProvider: AepUiContentProvider
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AepListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AepListViewModel(contentProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
