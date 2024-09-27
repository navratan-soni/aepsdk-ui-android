package com.adobe.marketing.mobile.aepcomposeui.uimodel


data class AEPFont(
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