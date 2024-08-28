package com.adobe.marketing.mobile.aepcomposeui.uimodel

import androidx.compose.runtime.mutableStateOf
import java.net.URL

class AEPButton(schemaData: Map<String, Any>) {

    // The text model for the button's label.
    val text = mutableStateOf<AEPText?>(null)

    // Unique identifier for tracking button interactions.
    val interactId = mutableStateOf("")

    // The URL to be opened when the button is tapped.
    val actionUrl = mutableStateOf<URL?>(null)

    // The parent template that contains this button.
   /* var parentTemplate: ContentCardTemplate? = template
        private set
*/
    // Initializer block to initialize the properties.
    init {
        // Extract the button text.
        // Bail out if the button text is not present.
        val buttonTextData =
            schemaData[Constants.CardTemplate.UIElement.Button.TEXT] as? Map<String, Any>
        val buttonText = buttonTextData?.let { AEPText(it) }

        if (buttonText != null) {
            text.value = buttonText
        }
        // Extract the interactId.
        // Bail out if the interact Id is not present.
        val interactIdValue =
            schemaData[Constants.CardTemplate.UIElement.Button.INTERACTION_ID] as? String
        if (interactIdValue != null) {
            interactId.value = interactIdValue
        }

        // Extract the actionUrl if available.
        val urlString = schemaData[Constants.CardTemplate.UIElement.Button.ACTION_URL] as? String
        val url = urlString?.let { URL(it) }
        actionUrl.value = url
    }
}