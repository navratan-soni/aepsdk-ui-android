package com.adobe.marketing.mobile.aepcomposeui.uicomposablepreviews

import AEPButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.adobe.marketing.mobile.aepcomposeui.uicomposables.AEPButtonComposable
import com.adobe.marketing.mobile.aepuitemplates.utils.Constants


@Preview(showBackground = true)
@Composable
fun PreviewButton() {
    val buttonSchemaMap = mapOf(
        Constants.CardTemplate.UIElement.Button.INTERACTION_ID to "button1",
        Constants.CardTemplate.UIElement.Button.TEXT to mapOf(
            Constants.CardTemplate.UIElement.Text.CONTENT to "Click Me",
            Constants.CardTemplate.UIElement.Text.CLR to "#FF0000CC",
            Constants.CardTemplate.UIElement.Text.ALIGN to "center",
            Constants.CardTemplate.UIElement.Text.FONT to mapOf(
                "name" to "Arial",
                "size" to 16,
                "weight" to "bold",
                "style" to listOf("italic")
            )
        ),
        Constants.CardTemplate.UIElement.Button.ACTION_URL to "https://www.adobe.com",
        "borWidth" to 2,
        "borColor" to "#0FE608AC"
    )

    val aepButton = AEPButton(buttonSchemaMap)

    AEPButtonComposable(
        interactId = aepButton.interactId!!,
        text = aepButton.text!!,
        actionUrl = aepButton.actionUrl!!,
        borWidth = aepButton.borWidth,
        borColor = aepButton.borColor
    )
}