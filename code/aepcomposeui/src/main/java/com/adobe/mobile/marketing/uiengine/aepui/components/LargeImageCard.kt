package com.adobe.mobile.marketing.uiengine.aepui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.adobe.mobile.marketing.uiengine.aepui.LargeImageAepUi
import com.adobe.mobile.marketing.uiengine.aepui.style.AepUiStyle
import com.adobe.mobile.marketing.uiengine.aepui.style.LargeImageAepUiStyle
import com.adobe.mobile.marketing.uiengine.interactions.UIEvent
import com.adobe.mobile.marketing.uiengine.observers.AepUiEventObserver

/**
 * Composable for rendering a Large Image Card
 */
@Composable
internal fun LargeImageCard(
    ui: LargeImageAepUi,
    style: LargeImageAepUiStyle,
    observer: AepUiEventObserver?,
) {

    LaunchedEffect(key1 = Unit) {
        observer?.onEvent(UIEvent.Display(ui))
    }

    DisposableEffect(Unit) {
        onDispose {
            observer?.onEvent(UIEvent.Dismiss(ui))
        }
    }

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(4f / 3f) // Aspect ratio to maintain 3/4th image height
            ) {
                AsyncImage(
                    model = ui.getTemplate().imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f)) // Dark overlay for better text visibility
                )

                ui.getTemplate().title?.let {
                    Text(
                        text = it.content,
                        style = style.getTitleTextStyle(ui.getTemplate()),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = ui.getTemplate().description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        observer?.onEvent(UIEvent.Click(ui))
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = ui.getTemplate().cta)
                }
            }
        }
    }
}