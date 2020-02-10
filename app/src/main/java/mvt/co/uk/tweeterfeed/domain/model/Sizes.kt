package mvt.co.uk.tweeterfeed.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sizes(

    @Json(name = "small")
    val small: Small? = null,

    @Json(name = "large")
    val large: Large? = null,

    @Json(name = "thumb")
    val thumb: Thumb? = null,

    @Json(name = "medium")
    val medium: Medium? = null
)