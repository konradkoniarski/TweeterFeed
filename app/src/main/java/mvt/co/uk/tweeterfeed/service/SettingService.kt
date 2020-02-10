package mvt.co.uk.tweeterfeed.service

import android.content.Context
import mvt.co.uk.tweeterfeed.R

/**
 * Copyright (c) 2020 Mobile Vision Technologies LTD. All rights reserved.
 * Created on 2020-02-09.
 */
class SettingService(val context: Context) {

    fun getCakeApiUrl(): String {
        return context.getString(R.string.tweeter_feed_api)
    }

    fun getToken(): String {
        return context.getString(R.string.tweeter_feed_api_token)
    }
}