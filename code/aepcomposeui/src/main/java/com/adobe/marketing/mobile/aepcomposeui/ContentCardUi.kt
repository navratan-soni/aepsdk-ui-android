package com.adobe.marketing.mobile.aepcomposeui

import android.util.Log
import com.adobe.marketing.mobile.Messaging
import com.adobe.marketing.mobile.aepcomposeui.uimodel.BaseTemplateModel
import com.adobe.marketing.mobile.aepcomposeui.uimodel.SmallImageTemplateModel
import com.adobe.marketing.mobile.messaging.Proposition
import com.adobe.marketing.mobile.messaging.SchemaType
import com.adobe.marketing.mobile.messaging.Surface

object ContentCardUi {
    fun getCardsForSurface(surface: Surface, callBack: UiCallback) {
 //       val surfaceItem = Surface("soni")

//        val surface = Surface("feeds/apifeed")

        //var propositions = mutableListOf<Proposition>()
        val surfaceList = mutableListOf<Surface>()

        surfaceList.add(surface)
        //mobileapp://com.adobe.marketing.mobile.notificationbuilder.testapp/soni
        Messaging.updatePropositionsForSurfaces(surfaceList)
        Messaging.getPropositionsForSurfaces(surfaceList) { map: Map<Surface, List<Proposition>> ->
            val templateModelList = mutableListOf<BaseTemplateModel>()
            println("getPropositionsForSurfaces callback contained ${map.entries.size} entry/entries for surface ${surface.uri}")
            for (entryOfSurfaceAndPropositionsList in map.entries) { // it is mutable map where key is surface and value is list of propositions
                for (propositionList in entryOfSurfaceAndPropositionsList.value) { // iterating through each proposition in the list
                    if (isContentCard(propositionList)) {
                        for (propositionItem in propositionList.items) { // Each proposition has a list of PropositionItems
                            var baseTempalte = propositionItem.contentCardSchemaData?.let {
                                // Factory
                                SmallImageTemplateModel().getTemplateFromContentCardSchemaData(
                                    it
                                )
                            }
                            templateModelList.add(baseTempalte!!)
                        }
                    }
                }
            }

            callBack.onContentCardReceived(templateModelList)
        }
    }

    private fun isContentCard(proposition: Proposition): Boolean {
        return proposition.items[0].schema == SchemaType.CONTENT_CARD
    }
}