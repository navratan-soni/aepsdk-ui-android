package com.adobe.marketing.mobile.aepcomposeui.uimodel

data class AEPText(
    val content: String? = null,
    val clr: String? = null,
    val align: String? = null,
    val font: Font? = null
) {
    constructor(textSchemaMap: Map<String, Any>) : this(
        content = textSchemaMap[Constants.CardTemplate.UIElement.Text.CONTENT] as? String,
        clr = textSchemaMap[Constants.CardTemplate.UIElement.Text.CLR] as? String,
        align = textSchemaMap[Constants.CardTemplate.UIElement.Text.ALIGN] as? String,
        font = (textSchemaMap[Constants.CardTemplate.UIElement.Text.FONT] as? Map<String, Any>)?.let {
            Font(
                it
            )
        }
    )

    data class Font(
        val name: String? = null,
        val size: Int? = null,
        val weight: String? = null,
        val style: List<String>? = null
    ) {
        constructor(fontMap: Map<String, Any>) : this(
            name = fontMap["name"] as? String,
            size = (fontMap["size"] as? Number)?.toInt(),
            weight = fontMap["weight"] as? String,
            style = (fontMap["style"] as? List<*>)?.filterIsInstance<String>()
        )
    }
}
