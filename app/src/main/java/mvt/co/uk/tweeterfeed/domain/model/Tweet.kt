package mvt.co.uk.tweeterfeed.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tweet(

    @Json(name = "in_reply_to_status_id_str")
    val inReplyToStatusIdStr: Any? = null,

    @Json(name = "in_reply_to_status_id")
    val inReplyToStatusId: Any? = null,

    @Json(name = "created_at")
    val createdAt: String? = null,

    @Json(name = "in_reply_to_user_id_str")
    val inReplyToUserIdStr: Any? = null,

    @Json(name = "source")
    val source: String? = null,

    @Json(name = "retweeted_status")
    val retweetedStatus: RetweetedStatus? = null,

    @Json(name = "retweet_count")
    val retweetCount: Int? = null,

    @Json(name = "retweeted")
    val retweeted: Boolean? = null,

    @Json(name = "geo")
    val geo: Any? = null,

    @Json(name = "in_reply_to_screen_name")
    val inReplyToScreenName: Any? = null,

    @Json(name = "is_quote_status")
    val isQuoteStatus: Boolean? = null,

    @Json(name = "full_text")
    val fullText: String? = null,

    @Json(name = "id_str")
    val idStr: String? = null,

    @Json(name = "in_reply_to_user_id")
    val inReplyToUserId: Any? = null,

    @Json(name = "favorite_count")
    val favoriteCount: Int? = null,

    @Json(name = "id")
    val id: Long? = null,

    @Json(name = "place")
    val place: Any? = null,

    @Json(name = "lang")
    val lang: String? = null,

    @Json(name = "favorited")
    val favorited: Boolean? = null,

    @Json(name = "coordinates")
    val coordinates: Any? = null,

    @Json(name = "truncated")
    val truncated: Boolean? = null,

    @Json(name = "entities")
    val entities: Entities? = null,

    @Json(name = "display_text_range")
    val displayTextRange: List<Int?>? = null,

    @Json(name = "contributors")
    val contributors: Any? = null,

    @Json(name = "user")
    val user: User? = null
)