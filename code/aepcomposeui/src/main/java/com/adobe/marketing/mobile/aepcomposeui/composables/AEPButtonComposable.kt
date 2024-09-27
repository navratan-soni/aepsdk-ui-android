package com.adobe.marketing.mobile.aepcomposeui.uicomposables

// File: AEPButtonComposable.kt

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.adobe.marketing.mobile.aepcomposeui.uimodel.AEPText

@Composable
fun AEPButtonComposable(
    interactId: String,
    text: AEPText,
    actionUrl: String,
    borWidth: Int? = null,
    borColor: String? = null
) {
    // Check for mandatory fields
    require(interactId.isNotEmpty()) { "interactId is mandatory for AEPButtonComposable" }
    require(text.content != null) { "text.content is mandatory for AEPButtonComposable" }
    require(actionUrl.isNotEmpty()) { "actionUrl is mandatory for AEPButtonComposable" }

    // Set optional border properties
    val borderColor = borColor?.let { Color(android.graphics.Color.parseColor(it)) } ?: Color.Transparent

    // Composable for Button
    Button(
        onClick = {
            // Handle button click logic
            println("Button clicked with action URL: $actionUrl")
        },
        border = borWidth?.let { BorderStroke(it.dp, borderColor) },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
        modifier = Modifier.padding(8.dp) // Modifier with padding to avoid layout issues
    ) {
        // Use AEPTextComposable to render the button text
        AEPTextComposable(
            content = text.content.orEmpty(),
            clr = text.clr,
            align = text.align,
            font = text.font
        )
    }
}