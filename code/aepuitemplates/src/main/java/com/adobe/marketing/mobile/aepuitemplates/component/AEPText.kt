package com.adobe.marketing.mobile.aepcomposeui.uimodel

import com.adobe.marketing.mobile.aepuitemplates.utils.Constants

data class AEPText(
    val content: String? = null,
    val clr: String? = null,
    val align: String? = null,
    val font: AEPFont? = null
) {
    constructor(textSchemaMap: Map<String, Any>) : this(
        content = textSchemaMap[Constants.CardTemplate.UIElement.Text.CONTENT] as? String,
        clr = textSchemaMap[Constants.CardTemplate.UIElement.Text.CLR] as? String,
        align = textSchemaMap[Constants.CardTemplate.UIElement.Text.ALIGN] as? String,
        font = (textSchemaMap[Constants.CardTemplate.UIElement.Text.FONT] as? Map<String, Any>)?.let {
            AEPFont(
                it
            )
        }
    )
}
