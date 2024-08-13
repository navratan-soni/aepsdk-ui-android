package com.adobe.marketing.mobile.aepcomposeui.uielement

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.adobe.marketing.mobile.messaging.ContentCard

@Composable
fun AEPTextView(string: String = "Hello World") {
    BasicText(text = string)
}