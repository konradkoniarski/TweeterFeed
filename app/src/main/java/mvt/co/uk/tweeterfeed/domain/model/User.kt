package mvt.co.uk.tweeterfeed.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(

    @Json(name = "utc_offset")
    val utcOffset: Any? = null,

    @Json(name = "friends_count")
    val friendsCount: Int? = null,

    @Json(name = "profile_image_url_https")
    val profileImageUrlHttps: String? = null,

    @Json(name = "listed_count")
    val listedCount: Int? = null,

    @Json(name = "profile_background_image_url")
    val profileBackgroundImageUrl: String? = null,

    @Json(name = "default_profile_image")
    val defaultProfileImage: Boolean? = null,

    @Json(name = "favourites_count")
    val favouritesCount: Int? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "created_at")
    val createdAt: String? = null,

    @Json(name = "is_translator")
    val isTranslator: Boolean? = null,

    @Json(name = "profile_background_image_url_https")
    val profileBackgroundImageUrlHttps: String? = null,

    @Json(name = "protected")
    val jsonMemberProtected: Boolean? = null,

    @Json(name = "screen_name")
    val screenName: String? = null,

    @Json(name = "id_str")
    val idStr: String? = null,

    @Json(name = "profile_link_color")
    val profileLinkColor: String? = null,

    @Json(name = "is_translation_enabled")
    val isTranslationEnabled: Boolean? = null,

    @Json(name = "translator_type")
    val translatorType: String? = null,

    @Json(name = "id")
    val id: Long? = null,

    @Json(name = "geo_enabled")
    val geoEnabled: Boolean? = null,

    @Json(name = "profile_background_color")
    val profileBackgroundColor: String? = null,

    @Json(name = "lang")
    val lang: Any? = null,

    @Json(name = "has_extended_profile")
    val hasExtendedProfile: Boolean? = null,

    @Json(name = "profile_sidebar_border_color")
    val profileSidebarBorderColor: String? = null,

    @Json(name = "profile_text_color")
    val profileTextColor: String? = null,

    @Json(name = "verified")
    val verified: Boolean? = null,

    @Json(name = "profile_image_url")
    val profileImageUrl: String? = null,

    @Json(name = "time_zone")
    val timeZone: Any? = null,

    @Json(name = "url")
    val url: String? = null,

    @Json(name = "contributors_enabled")
    val contributorsEnabled: Boolean? = null,

    @Json(name = "profile_background_tile")
    val profileBackgroundTile: Boolean? = null,

    @Json(name = "profile_banner_url")
    val profileBannerUrl: String? = null,

    @Json(name = "entities")
    val entities: Entities? = null,

    @Json(name = "statuses_count")
    val statusesCount: Int? = null,

    @Json(name = "follow_request_sent")
    val followRequestSent: Any? = null,

    @Json(name = "followers_count")
    val followersCount: Int? = null,

    @Json(name = "profile_use_background_image")
    val profileUseBackgroundImage: Boolean? = null,

    @Json(name = "default_profile")
    val defaultProfile: Boolean? = null,

    @Json(name = "following")
    val following: Any? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "location")
    val location: String? = null,

    @Json(name = "profile_sidebar_fill_color")
    val profileSidebarFillColor: String? = null,

    @Json(name = "notifications")
    val notifications: Any? = null
)