package mvt.co.uk.tweeterfeed.service

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


class AuthInterceptor(
    val settings: SettingService
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        val token = settings.getToken()

        val original = chain.request()
        val builder = original.newBuilder()

            .header(
                "Authorization",
                token
            )
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")

        val request = builder.build()
        return chain.proceed(request)
    }
}