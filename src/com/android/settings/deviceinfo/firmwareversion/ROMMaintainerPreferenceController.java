/*
 * Copyright (C) 2019 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class ROMMaintainerPreferenceController  extends BasePreferenceController {

    private static final String TAG = "ROMMaintainerPreferenceController";
    private static final String AOSIP_RELEASETYPE = "ro.aosip.buildtype";
    private static final String DERP_MAINTAINER = "ro.derp.maintainer";

    public ROMMaintainerPreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        String buildType = SystemProperties.get(AOSIP_RELEASETYPE);
        if (buildType == "Derped") {
            return AVAILABLE;
        }
        return CONDITIONALLY_UNAVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        return SystemProperties.get(DERP_MAINTAINER,
                mContext.getString(R.string.unknown));
    }
}

