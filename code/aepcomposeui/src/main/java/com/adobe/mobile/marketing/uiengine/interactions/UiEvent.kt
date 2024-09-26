package com.adobe.mobile.marketing.uiengine.interactions

import com.adobe.marketing.mobile.aepuitemplates.AepUiTemplate
import com.adobe.mobile.marketing.uiengine.aepui.AepUI
import com.adobe.mobile.marketing.uiengine.aepui.state.AepUiState

sealed interface UIEvent<T : AepUiTemplate, S : AepUiState> {
    data class Display<T : AepUiTemplate, S : AepUiState>(val _aepui: AepUI<T, S>) : UIEvent<T, S>
    data class Click<T : AepUiTemplate, S : AepUiState>(val _aepui: AepUI<T, S>) : UIEvent<T, S>
    data class Dismiss<T : AepUiTemplate, S : AepUiState>(val _aepui: AepUI<T, S>) : UIEvent<T, S>
    data class Expand<T : AepUiTemplate, S : AepUiState>(val _aepui: AepUI<T, S>) : UIEvent<T, S>
}
