/*
  Copyright 2024 Adobe. All rights reserved.
  This file is licensed to you under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software distributed under
  the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
  OF ANY KIND, either express or implied. See the License for the specific language
  governing permissions and limitations under the License.
 */

package com.adobe.marketing.mobile.notificationbuilder.testapp

import android.app.Application
import androidx.lifecycle.Lifecycle
import com.adobe.marketing.mobile.LoggingMode
import com.adobe.marketing.mobile.MobileCore
import com.adobe.marketing.mobile.CampaignClassic
import com.adobe.marketing.mobile.Edge
import com.adobe.marketing.mobile.Messaging
import com.adobe.marketing.mobile.edge.identity.Identity

class MyApp : Application() {

    private val ENVIRONMENT_FILE_ID = "3149c49c3910/b6541e5e6301/launch-f7ac0a320fb3-development"
    private val ASSURANCE_SESSION_ID = "messagingsampleapp://?adb_validation_sessionid=0f863a13-1123-4a92-8a4f-0da78593766a"
    private val STAGING_APP_ID = "staging/1b50a869c4a2/bcd1a623883f/launch-e44d085fc760-development"
    private val STAGING = false
    override fun onCreate() {
        super.onCreate()
        MobileCore.setApplication(this)
        MobileCore.setLogLevel(LoggingMode.VERBOSE)

        val extensions = listOf(CampaignClassic.EXTENSION,Messaging.EXTENSION, Identity.EXTENSION)
        MobileCore.registerExtensions(extensions) {
            // Necessary property id which has the edge configuration id needed by aep sdk
            MobileCore.configureWithAppID(ENVIRONMENT_FILE_ID)
            MobileCore.lifecycleStart(null)
           // MobileCore.updateConfiguration(mapOf("messaging.useSandbox" to true))
        }
       // Assurance.startSession(ASSURANCE_SESSION_ID)

        /*FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            // Log and toast
            if (task.isSuccessful) {
                // Get new FCM registration token
                val token = task.result
                print("MessagingApplication Firebase token :: $token")
                // Syncing the push token with experience platform
                MobileCore.setPushIdentifier(token)
            }
        }*/

    }

}