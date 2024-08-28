package com.adobe.marketing.mobile.aepcomposeui.uimodel

import android.graphics.Color
import android.graphics.fonts.Font

enum class AEPTextType {
    TITLE,
    BODY,
    BUTTON;

    // The default font for the text type
    val defaultFont: Font? = null
       /* get() = when (this) {
            TITLE -> Constants.CardTemplate.DefaultStyle.Text.TITLE_FONT
            BODY -> Constants.CardTemplate.DefaultStyle.Text.BODY_FONT
            BUTTON -> Constants.CardTemplate.DefaultStyle.Text.BUTTON_FONT
        }*/

    // The default color for the text type
    val defaultColor: Color? = null
       /* get() = when (this) {
            TITLE -> Constants.CardTemplate.DefaultStyle.Text.TITLE_COLOR
            BODY -> Constants.CardTemplate.DefaultStyle.Text.BODY_COLOR
            BUTTON -> Constants.CardTemplate.DefaultStyle.Text.BUTTON_COLOR
        }*/
}