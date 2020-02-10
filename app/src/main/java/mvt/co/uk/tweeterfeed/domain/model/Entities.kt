package mvt.co.uk.tweeterfeed.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Entities(

    @Json(name = "description")
    val description: Description? = null,

    @Json(name = "url")
    val url: Url? = null,

    @Json(name = "urls")
    val urls: List<Any?>? = null,

    @Json(name = "hashtags")
    val hashtags: List<HashtagsItem?>? = null,

    @Json(name = "user_mentions")
    val userMentions: List<UserMentionsItem?>? = null,

    @Json(name = "symbols")
    val symbols: List<Any?>? = null,

    @Json(name = "media")
    val media: List<MediaItem?>? = null
)