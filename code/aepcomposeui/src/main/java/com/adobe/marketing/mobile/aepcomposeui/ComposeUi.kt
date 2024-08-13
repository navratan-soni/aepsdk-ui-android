package com.adobe.marketing.mobile.aepcomposeui

import com.adobe.marketing.mobile.Messaging
import com.adobe.marketing.mobile.messaging.Proposition
import com.adobe.marketing.mobile.messaging.SchemaType
import com.adobe.marketing.mobile.messaging.Surface

object ComposeUi {
    fun getCardsForSurface(surface: Surface, callBack:UiCallback) {

 //       val surfaceItem = Surface("soni")

//        val surface = Surface("feeds/apifeed")

        var propositions = mutableListOf<Proposition>()
        val surfaceList = mutableListOf<Surface>()
        surfaceList.add(surface)

        Messaging.updatePropositionsForSurfaces(surfaceList)
        Messaging.getPropositionsForSurfaces(surfaceList) {
            println("getPropositionsForSurfaces callback contained ${it.entries.size} entry/entries for surface ${surface.uri}")
            for (entry in it.entries) { // it is mutable map where key is surface and value is list of propositions
                for (proposition in entry.value) { // iterating through each proposition in the list
                    if (isContentCard(proposition)) {
                        for (item in proposition.items) { // Each proposition has a list of PropositionItems
                            val inboundContentSchemaData = item.contentCardSchemaData
                            inboundContentSchemaData!!.contentCard
                        }
                    }
                }
            }
        }

    }

    private fun isContentCard(proposition: Proposition): Boolean {
        return proposition.items[0].schema == SchemaType.CONTENT_CARD
    }
}