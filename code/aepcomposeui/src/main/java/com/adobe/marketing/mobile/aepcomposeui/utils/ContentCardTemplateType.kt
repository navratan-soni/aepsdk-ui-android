package com.adobe.marketing.mobile.aepcomposeui.utils

enum class ContentCardTemplateType(val type: String) {
    SMALL_IMAGE("SmallImage"),
    LARGE_IMAGE("LargeImage"),
    IMAGE_ONLY("ImageOnly"),
    UNKNOWN("Unknown");

    companion object {
        fun from(string: String): ContentCardTemplateType {
            return values().find { it.type == string } ?: UNKNOWN
        }
    }
}
