package com.adobe.marketing.mobile.aepcomposeui.uicomposables

// File: AEPTextComposable.kt

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.adobe.marketing.mobile.aepcomposeui.uimodel.AEPText

@Composable
fun AEPTextComposable(
    content: String,
    clr: String? = null,
    align: String? = null,
    font: AEPText.Font? = null
) {
    // Check for mandatory field
    require(content.isNotEmpty()) { "content is mandatory for AEPTextComposable" }

    // Parse color from string to Color object, with exception handling
    val textColor = try {
        clr?.let { Color(android.graphics.Color.parseColor(it)) } ?: androidx.compose.ui.graphics.Color.Black
    } catch (e: IllegalArgumentException) {
        androidx.compose.ui.graphics.Color.Black // Fallback to black if the color string is invalid
    }

    // Determine text alignment safely
    val textAlign = when (align?.lowercase()) {
        "left" -> TextAlign.Left
        "center" -> TextAlign.Center
        "right" -> TextAlign.Right
        else -> TextAlign.Start
    }

    // Set font properties
    val fontFamily = FontFamily.Default // Use default or map from `font.name` if needed
    val fontSize = (font?.size ?: 14).sp
    val fontWeight = when (font?.weight?.lowercase()) {
        "bold" -> FontWeight.Bold
        else -> FontWeight.Normal
    }
    val fontStyle = if (font?.style?.contains("italic") == true) {
        FontStyle.Italic
    } else {
        FontStyle.Normal
    }

    // Text Composable
    Text(
        text = content,
        color = textColor,
        textAlign = textAlign,
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        modifier = Modifier.fillMaxWidth()
    )
}