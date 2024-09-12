import com.adobe.marketing.mobile.aepcomposeui.uimodel.AEPText

data class AEPButton(
    val interactId: String? = null,
    val actionUrl: String? = null,
    val text: AEPText? = null,
    val borWidth: Int? = null,
    val borColor: String? = null
) {
    constructor(buttonSchemaMap: Map<String, Any>) : this(
        interactId = buttonSchemaMap[Constants.CardTemplate.UIElement.Button.INTERACTION_ID] as? String,
        actionUrl = buttonSchemaMap[Constants.CardTemplate.UIElement.Button.ACTION_URL] as? String,
        text = (buttonSchemaMap[Constants.CardTemplate.UIElement.Button.TEXT] as? Map<String, Any>)?.let { AEPText(it) },
        borWidth = (buttonSchemaMap[Constants.CardTemplate.UIElement.Button.BOR_WIDTH] as? Number)?.toInt(),
        borColor = buttonSchemaMap[Constants.CardTemplate.UIElement.Button.BOR_COLOR] as? String
    )
}
