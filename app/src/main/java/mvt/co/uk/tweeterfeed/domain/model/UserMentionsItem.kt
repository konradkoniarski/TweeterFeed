package mvt.co.uk.tweeterfeed.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserMentionsItem(

    @Json(name = "indices")
    val indices: List<Int?>? = null,

    @Json(name = "screen_name")
    val screenName: String? = null,

    @Json(name = "id_str")
    val idStr: String? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "id")
    val id: Long? = null
)