package mvt.co.uk.tweeterfeed.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Large(

    @Json(name = "w")
    val W: Int? = null,

    @Json(name = "h")
    val H: Int? = null,

    @Json(name = "resize")
    val resize: String? = null
)