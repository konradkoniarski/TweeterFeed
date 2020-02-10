package mvt.co.uk.tweeterfeed.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import mvt.co.uk.tweeterfeed.domain.model.Tweet
import mvt.co.uk.tweeterfeed.presentation.tweeterFeed.TweeterFeedViewModel
import mvt.co.uk.tweeterfeed.service.NetworkService
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest

/**
 * Copyright (c) 2020 Mobile Vision Technologies LTD. All rights reserved.
 * Created on 2020-02-10.
 */
class TweeterFeedViewModelTest : AutoCloseKoinTest() {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    val appModule = module {

        single { NetworkService(get()) }
        factory { TweeterFeedRepository(get()) }
        factory { TweeterFeedViewModel(get()) }

    }

    lateinit var viewModel: TweeterFeedViewModel

    var data = listOf(Tweet(fullText = "Tweet"))

    @Before
    fun before() {
        startKoin {
            modules(appModule)
        }
    }

    @Test
    fun whenAppStartedThenLoadDataFromRepository() {
        runBlocking {
            val mockRepository = mock<TweeterFeedRepository>()
            whenever(mockRepository.getStatuses()).thenReturn(data)
            viewModel = TweeterFeedViewModel(mockRepository)
            viewModel.start()
            verify(viewModel.repository).getStatuses()
        }
    }
    //TODO: add more test here
}