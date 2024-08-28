package com.adobe.marketing.mobile.aepcomposeui.uimodel

import com.adobe.marketing.mobile.messaging.ContentCardSchemaData
import com.adobe.marketing.mobile.util.DataReader

class SmallImageTemplateModel : BaseTemplateModel() {
    var title: String = ""
    var body: String = ""
    var imageUrl: String = ""
    override fun getTemplateFromContentCardSchemaData(contentCardSchemaData: ContentCardSchemaData): BaseTemplateModel {
        val contentMap: Map<String, Any> = contentCardSchemaData.content as Map<String, Any>
        title = DataReader.optString(contentMap, "title", "")
        body = DataReader.optString(contentMap, "body", "")
        imageUrl = DataReader.optString(contentMap, "imageUrl", "")
        return this
    }
}