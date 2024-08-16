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

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import com.adobe.marketing.mobile.aepcomposeui.ContentCardUi
import com.adobe.marketing.mobile.aepcomposeui.UiCallback
import com.adobe.marketing.mobile.aepcomposeui.uitemplate.ContentCardTemplate
import com.adobe.marketing.mobile.notificationbuilder.testapp.notificationBuilder.UINotificationBuilderActivity
import com.adobe.marketing.mobile.notificationbuilder.testapp.ui.theme.AepsdkTheme
import com.adobe.marketing.mobile.services.ServiceProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val packageName = ServiceProvider.getInstance()
            .deviceInfoService
            .applicationPackageName

        val surface = com.adobe.marketing.mobile.messaging.Surface("soni")
        setContent {
            AepsdkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "AEP SDK \n UI Components ${packageName}",
                            modifier = Modifier.padding(16.dp),
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.height(40.dp))
                        Button(onClick = {
                            startActivity(Intent(this@MainActivity, UINotificationBuilderActivity::class.java))
                        }) {
                            Text("Notification Builder")
                        }

                        Button(onClick = {
                            ContentCardUi.getCardsForSurface(surface, object: UiCallback {
                                override fun onContentCardReceived(contentCardTemplate: ContentCardTemplate) {
                                    showtoast()
                                }
                            })
                        }) {
                            Text("Fetch content card")
                        }
                    }
                }
            }
        }
        requestNotificationPermission()
    }

    private fun showtoast() {
        val context = this@MainActivity
        Toast.makeText(context, "Content card received", Toast.LENGTH_SHORT).show()
    }

    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    1
                )
            }
        }
    }
}