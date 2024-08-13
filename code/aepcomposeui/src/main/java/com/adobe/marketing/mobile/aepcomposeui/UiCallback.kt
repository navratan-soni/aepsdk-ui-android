package com.adobe.marketing.mobile.aepcomposeui

import com.adobe.marketing.mobile.aepcomposeui.uitemplate.ContentCardTemplate

interface UiCallback {
    fun onContentCardReceived(contentCardTemplate: ContentCardTemplate)
}