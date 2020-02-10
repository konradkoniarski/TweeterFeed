package mvt.co.uk.tweeterfeed.repository

import mvt.co.uk.tweeterfeed.domain.model.Tweet
import mvt.co.uk.tweeterfeed.service.NetworkService
import org.koin.core.KoinComponent

/**
 * Copyright (c) 2020 Mobile Vision Technologies LTD. All rights reserved.
 * Created on 2020-02-09.
 */
class TweeterFeedRepository(val networkService: NetworkService) : KoinComponent {

    suspend fun getStatuses(): List<Tweet> {
        //TODO: hardcoded parameters
        val listId = 871746761387323394
        val tweetMode = "extended"
        val includeEntities = 1
        val count = 10
        //TODO: end

        return networkService.getTweeterFeedApi()
            .getStatuses(listId, tweetMode, includeEntities, count)
    }
}