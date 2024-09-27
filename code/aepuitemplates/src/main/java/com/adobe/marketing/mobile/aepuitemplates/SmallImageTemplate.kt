package com.adobe.marketing.mobile.aepuitemplates

import com.adobe.marketing.mobile.aepcomposeui.uimodel.AEPImage
import com.adobe.marketing.mobile.aepcomposeui.uimodel.AEPText
import com.adobe.marketing.mobile.aepuitemplates.utils.AepUiTemplateType
import com.adobe.marketing.mobile.util.DataReader

class SmallImageTemplate(
    var image: AEPImage? = null,
    var title: AEPText? = null,
    var description: AEPText? = null
) : AepUiTemplate {
    constructor(jsonSchemaMap: Map<String, Any>) : this(
        //TODO correct parsing to be added
        image = AEPImage(jsonSchemaMap["imageUrl"] as Map<String, Any>),
        title = AEPText(jsonSchemaMap["title"] as Map<String, Any>),
        description = AEPText(jsonSchemaMap["description"] as Map<String, Any>)
    )

    override fun getType() = AepUiTemplateType.SMALL_IMAGE.typeName
}

