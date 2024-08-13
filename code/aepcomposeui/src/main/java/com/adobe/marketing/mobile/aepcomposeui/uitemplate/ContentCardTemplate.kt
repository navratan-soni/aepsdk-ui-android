package com.adobe.marketing.mobile.aepcomposeui.uitemplate

import androidx.compose.runtime.Composable
import com.adobe.marketing.mobile.messaging.ContentCardSchemaData

interface ContentCardTemplate {
    @Composable
    abstract fun GetUi(contentCardSchemaData: ContentCardSchemaData)
}