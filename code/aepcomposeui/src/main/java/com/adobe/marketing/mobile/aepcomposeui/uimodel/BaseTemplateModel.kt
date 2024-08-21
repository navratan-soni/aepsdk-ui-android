package com.adobe.marketing.mobile.aepcomposeui.uimodel

import com.adobe.marketing.mobile.messaging.ContentCardSchemaData

abstract class BaseTemplateModel {
    abstract fun getTemplateFromContentCardSchemaData(contentCardSchemaData: ContentCardSchemaData): BaseTemplateModel
}