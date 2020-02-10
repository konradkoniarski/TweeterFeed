package mvt.co.uk.tweeterfeed.service

import mvt.co.uk.tweeterfeed.domain.model.Tweet
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Copyright (c) 2020 Mobile Vision Technologies LTD. All rights reserved.
 * Created on 2020-02-09.
 */
interface TweeterFeedApi {

    @GET("lists/statuses.json")
    suspend fun getStatuses(
        @Query("list_id") listId: Long,
        @Query("tweet_mode") tweetMode: String,
        @Query("include_entities") includeEntities: Int,
        @Query("count") int: Int
    ): List<Tweet>
}