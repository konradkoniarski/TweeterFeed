package mvt.co.uk.tweeterfeed.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UrlsItem(

    @Json(name = "display_url")
    val displayUrl: String? = null,

    @Json(name = "indices")
    val indices: List<Int?>? = null,

    @Json(name = "expanded_url")
    val expandedUrl: String? = null,

    @Json(name = "url")
    val url: String? = null
)