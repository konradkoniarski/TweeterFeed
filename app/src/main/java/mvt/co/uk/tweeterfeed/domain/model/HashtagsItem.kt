package mvt.co.uk.tweeterfeed.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HashtagsItem(

    @Json(name = "indices")
    val indices: List<Int?>? = null,

    @Json(name = "text")
    val text: String? = null
)