package com.adobe.mobile.marketing.uiengine.observers

import com.adobe.mobile.marketing.uiengine.interactions.UIEvent

interface AepUiEventObserver {
    fun onEvent(event: UIEvent<*, *>)
}