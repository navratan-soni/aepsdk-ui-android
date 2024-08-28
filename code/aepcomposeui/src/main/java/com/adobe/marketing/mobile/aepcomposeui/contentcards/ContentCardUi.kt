package com.adobe.marketing.mobile.aepcomposeui.contentcards

import com.adobe.marketing.mobile.aepcomposeui.uimodel.BaseTemplateModel
import com.adobe.marketing.mobile.aepcomposeui.uimodel.SmallImageTemplateModel
import com.adobe.marketing.mobile.aepcomposeui.utils.ContentCardTemplateType
import com.adobe.marketing.mobile.aepcomposeui.utils.getTemplateType
import com.adobe.marketing.mobile.messaging.ContentCardSchemaData
import com.adobe.marketing.mobile.messaging.Proposition
import com.adobe.marketing.mobile.messaging.SchemaType

object ContentCardUi {
    fun buildTemplate(proposition: Proposition): BaseTemplateModel? {

        var baseTemplateModel: BaseTemplateModel? = null

        if (isContentCard(proposition)) {
            val propositionItem = proposition.items[0]
            baseTemplateModel = propositionItem.contentCardSchemaData?.let {
                getTemplateModelFromContentCardSchemaData(it)
            }
        }
        return baseTemplateModel
    }

    private fun isContentCard(proposition: Proposition): Boolean {
        return proposition.items[0].schema == SchemaType.CONTENT_CARD
    }

    private fun getTemplateModelFromContentCardSchemaData(contentCardSchemaData: ContentCardSchemaData): BaseTemplateModel? {
        val templateType = contentCardSchemaData.getTemplateType()

        return when (templateType) {
            ContentCardTemplateType.SMALL_IMAGE -> SmallImageTemplateModel().getTemplateFromContentCardSchemaData(
                contentCardSchemaData
            )

            else -> SmallImageTemplateModel().getTemplateFromContentCardSchemaData(
                contentCardSchemaData
            )
        }
    }
}