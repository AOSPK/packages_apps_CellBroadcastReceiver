/*
 * Copyright (C) 2011 The Android Open Source Project
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

package com.android.cellbroadcastreceiver;

import android.app.Application;
import android.telephony.SmsCbMessage;

import java.util.ArrayList;

/**
 * The application class loads the default preferences at first start,
 * and remembers the time of the most recently received broadcast.
 */
public class CellBroadcastReceiverApp extends Application {
    private static final String TAG = "CellBroadcastReceiverApp";

    /** List of unread non-emergency alerts to show when user selects the notification. */
    private static final ArrayList<SmsCbMessage> sNewMessageList = new ArrayList<>(4);

    /** Adds a new unread non-emergency message and returns the current list. */
    static ArrayList<SmsCbMessage> addNewMessageToList(SmsCbMessage message) {
        sNewMessageList.add(message);
        return sNewMessageList;
    }

    /** Clears the list of unread non-emergency messages. */
    static void clearNewMessageList() {
        sNewMessageList.clear();
    }

    /** Returns a list of unread non-emergency alerts */
    static ArrayList<SmsCbMessage> getNewMessageList() {
        return sNewMessageList;
    }
}
