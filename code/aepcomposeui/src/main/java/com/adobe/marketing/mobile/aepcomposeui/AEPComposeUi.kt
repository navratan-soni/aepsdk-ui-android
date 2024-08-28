package com.adobe.marketing.mobile.aepcomposeui

import com.adobe.marketing.mobile.AdobeCallbackWithError
import com.adobe.marketing.mobile.AdobeError
import com.adobe.marketing.mobile.Messaging
import com.adobe.marketing.mobile.aepcomposeui.contentcards.ContentCardUi
import com.adobe.marketing.mobile.aepcomposeui.uimodel.BaseTemplateModel
import com.adobe.marketing.mobile.messaging.Proposition
import com.adobe.marketing.mobile.messaging.Surface

object AEPComposeUi {

    fun getCardsForSurface(surface: Surface,
                           completion: (Result<List<BaseTemplateModel>>) -> Unit) {
        val surfaceList = mutableListOf<Surface>()
        surfaceList.add(surface)

        // Update propositions for the provided surface
        Messaging.updatePropositionsForSurfaces(surfaceList)

        // Retrieve propositions for the provided surface
        Messaging.getPropositionsForSurfaces(surfaceList, object : AdobeCallbackWithError<Map<Surface, List<Proposition>>> {
            override fun call(resultMap: Map<Surface, List<Proposition>>?) {
                if (resultMap == null) {
                    completion(Result.failure(Throwable("resultMap null for surface ${surface.uri}")))
                    return
                }

                val templateModelList = mutableListOf<BaseTemplateModel>()
                println("getPropositionsForSurfaces callback contained ${resultMap.entries.size} entry/entries for surface ${surface.uri}")

                for ((_, propositions) in resultMap.entries) {
                    for (proposition in propositions) {
                        var baseTemplate = ContentCardUi.buildTemplate(proposition)
                        baseTemplate?.let { templateModelList.add(it) }
                    }
                }
                completion(Result.success(templateModelList))
            }

            override fun fail(error: AdobeError?) {
                completion(Result.failure(Throwable("Failed to retrieve propositions for surface ${surface.uri}")))
            }
        })
    }
}
