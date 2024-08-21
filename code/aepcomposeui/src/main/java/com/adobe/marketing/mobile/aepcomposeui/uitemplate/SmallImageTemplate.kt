package com.adobe.marketing.mobile.aepcomposeui.uitemplate

import androidx.compose.runtime.Composable
import com.adobe.marketing.mobile.aepcomposeui.uimodel.BaseTemplateModel
import com.adobe.marketing.mobile.aepcomposeui.uimodel.SmallImageTemplateModel


class SmallImageTemplate {
    @Composable
   fun GetUi(baseContentCardModel: BaseTemplateModel) {
        val smallImageTemplateModel = baseContentCardModel as SmallImageTemplateModel
       // TwoColumnLayout(smallImageTemplateModel)
    }


}