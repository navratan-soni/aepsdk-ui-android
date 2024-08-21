package com.adobe.marketing.mobile.aepcomposeui

import androidx.compose.runtime.Composable
import com.adobe.marketing.mobile.aepcomposeui.uimodel.BaseTemplateModel
import com.adobe.marketing.mobile.aepcomposeui.uitemplate.ContentCardTemplate

interface UiCallback {
    fun onContentCardReceived(baseTemplateModel: BaseTemplateModel)
}