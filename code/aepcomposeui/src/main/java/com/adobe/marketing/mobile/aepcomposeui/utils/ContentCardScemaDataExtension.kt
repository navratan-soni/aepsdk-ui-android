package com.adobe.marketing.mobile.aepcomposeui.utils

import com.adobe.marketing.mobile.aepcomposeui.uimodel.AEPButton
import com.adobe.marketing.mobile.aepcomposeui.uimodel.AEPImage
import com.adobe.marketing.mobile.aepcomposeui.uimodel.AEPText
import com.adobe.marketing.mobile.messaging.ContentCardSchemaData
import java.net.URL

fun ContentCardSchemaData.getTemplateType(): ContentCardTemplateType {
    val templateString = getMetaAdobeData()?.get(Constants.TEMPLATE) as? String
    return if (templateString != null) {
        ContentCardTemplateType.from(templateString)
    } else {
        ContentCardTemplateType.UNKNOWN
    }
}

fun ContentCardSchemaData.getTitle(): AEPText? {
    val titleData = getContentMap()?.get(Constants.TITLE) as? Map<String, Any>
    return titleData?.let { AEPText(it) }
}

fun ContentCardSchemaData.getBody(): AEPText? {
    val bodyData = getContentMap()?.get(Constants.BODY) as? Map<String, Any>
    return bodyData?.let { AEPText(it) }
}

fun ContentCardSchemaData.getImage(): AEPImage? {
    val imageData = getContentMap()?.get(Constants.IMAGE) as? Map<String, Any>
    return imageData?.let { AEPImage(it) }
}

fun ContentCardSchemaData.getButtons(): List<AEPButton>? {
    val buttonsData = getContentMap()?.get(Constants.BUTTONS) as? List<Map<String, Any>>
    return buttonsData?.mapNotNull { AEPButton(it) }
}

fun ContentCardSchemaData.getActionUrl(): URL? {
    val actionUrlString = getContentMap()?.get(Constants.ACTION_URL) as? String
    return actionUrlString?.let { URL(it) }
}

// Private extension functions for internal usage
private fun ContentCardSchemaData.getContentMap(): Map<String, Any>? {
    return content as? Map<String, Any>
}

private fun ContentCardSchemaData.getMetaAdobeData(): Map<String, Any>? {
    return meta?.get(Constants.ADOBE_DATA) as? Map<String, Any>
}