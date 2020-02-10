package mvt.co.uk.tweeterfeed.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MediaItem(

    @Json(name = "display_url")
    val displayUrl: String? = null,

    @Json(name = "indices")
    val indices: List<Int?>? = null,

    @Json(name = "sizes")
    val sizes: Sizes? = null,

    @Json(name = "id_str")
    val idStr: String? = null,

    @Json(name = "expanded_url")
    val expandedUrl: String? = null,

    @Json(name = "media_url_https")
    val mediaUrlHttps: String? = null,

    @Json(name = "id")
    val id: Long? = null,

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "media_url")
    val mediaUrl: String? = null,

    @Json(name = "url")
    val url: String? = null
)