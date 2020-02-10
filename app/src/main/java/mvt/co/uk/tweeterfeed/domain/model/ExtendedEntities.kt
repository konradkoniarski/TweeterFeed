package mvt.co.uk.tweeterfeed.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExtendedEntities(

    @Json(name = "media")
    val media: List<MediaItem?>? = null
)