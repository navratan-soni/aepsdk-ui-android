package com.adobe.marketing.mobile.aepcomposeui.uitemplate

import androidx.compose.runtime.Composable
import com.adobe.marketing.mobile.aepcomposeui.uielement.AEPTextView
import com.adobe.marketing.mobile.messaging.ContentCard
import com.adobe.marketing.mobile.messaging.ContentCardSchemaData


class SmallImageTemplate: ContentCardTemplate{
    @Composable
    override fun GetUi(contentCardSchemaData: ContentCardSchemaData) {
        contentCardSchemaData.contentCard
        AEPTextView()
    }

}