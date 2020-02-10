package mvt.co.uk.tweeterfeed

import android.app.Application
import android.os.StrictMode
import mvt.co.uk.tweeterfeed.presentation.tweeterFeed.TweeterFeedViewModel
import mvt.co.uk.tweeterfeed.repository.TweeterFeedRepository
import mvt.co.uk.tweeterfeed.service.NetworkService
import mvt.co.uk.tweeterfeed.service.SettingService
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

/**
 * Copyright (c) 2020 Mobile Vision Technologies LTD. All rights reserved.
 * Created on 2020-02-09.
 */
class TweeterFeedApplication : Application() {

    val appModule = module {
        single { NetworkService(get()) }
        single { SettingService(get()) }

        single { TweeterFeedRepository(get()) }

        viewModel { TweeterFeedViewModel(get()) }
    }

    override fun onCreate() {

        if (BuildConfig.DEBUG) {//TODO: or developer mode
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build()
            )
        }

        super.onCreate()

        startKoin {
            androidContext(this@TweeterFeedApplication)
            modules(appModule)
        }

        Timber.plant(Timber.DebugTree())
    }
}