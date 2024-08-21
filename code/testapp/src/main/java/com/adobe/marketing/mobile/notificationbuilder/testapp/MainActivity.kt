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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import com.adobe.marketing.mobile.aepcomposeui.ContentCardUi
import com.adobe.marketing.mobile.aepcomposeui.UiCallback
import com.adobe.marketing.mobile.aepcomposeui.uimodel.BaseTemplateModel
import com.adobe.marketing.mobile.aepcomposeui.uimodel.SmallImageTemplateModel
import com.adobe.marketing.mobile.aepcomposeui.uitemplate.ContentCardTemplate
import com.adobe.marketing.mobile.aepcomposeui.uitemplate.SmallImageTemplate
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
                var baseTemplateModelData by remember { mutableStateOf<BaseTemplateModel?>(null) }
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
                            ContentCardUi.getCardsForSurface(surface, object : UiCallback {
                                override fun onContentCardReceived(baseTemplateModel: BaseTemplateModel) {
                                    baseTemplateModelData = baseTemplateModel
                                }
                            })
                        }) {
                            Text("Fetch content card")
                        }

                        if (baseTemplateModelData != null) {
                            TwoColumnLayout(baseTemplateModelData!! as SmallImageTemplateModel)
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


    @Composable
    fun TwoColumnLayout(smallImageTemplateModel: SmallImageTemplateModel) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // First Column: Image
            /* Image(
                 painter = painterResource(id = android.R.drawable.btn_default_small),
                 contentDescription = "Your image description",
                 modifier = Modifier
                     .weight(1f)
             )*/

            Spacer(modifier = Modifier.width(16.dp))

            // Second Column: Texts in vertical arrangement
            Column(
                modifier = Modifier.weight(2f)
            ) {
                // Top TextView: Bold Text
                Text(
                    text = smallImageTemplateModel.title,
                    style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.Black // Optional: Set text color
                )

                // Bottom TextView: Regular Text
                Text(
                    text = smallImageTemplateModel.body,
                    style = MaterialTheme.typography.h4,
                    color = Color.Gray // Optional: Set text color
                )
            }
        }
    }
}