package mvt.co.uk.tweeterfeed.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import mvt.co.uk.tweeterfeed.TestCoroutineRule
import mvt.co.uk.tweeterfeed.TestSchedulerService
import mvt.co.uk.tweeterfeed.domain.model.Tweet
import mvt.co.uk.tweeterfeed.presentation.tweeterFeed.TweeterFeedViewModel
import mvt.co.uk.tweeterfeed.service.NetworkService
import mvt.co.uk.tweeterfeed.service.SchedulerService
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.get

/**
 * Copyright (c) 2020 Mobile Vision Technologies LTD. All rights reserved.
 * Created on 2020-02-10.
 */
class TweeterFeedViewModelTest : AutoCloseKoinTest() {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = TestCoroutineRule()

    val appModule = module {

        single { TestSchedulerService() as SchedulerService }

        single { NetworkService(get()) }
        factory { TweeterFeedRepository(get()) }
        factory { TweeterFeedViewModel(get(), get()) }

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
            viewModel = TweeterFeedViewModel(mockRepository, get())
            viewModel.start()
            verify(viewModel.repository).getStatuses()
        }
    }

    @Test
    fun whenAppStartedAndLoadDataCheckIfDataIsCorrect() =
        runBlocking {
            val mockRepository = mock<TweeterFeedRepository>()
            given(mockRepository.getStatuses()).willReturn(data)
            viewModel = TweeterFeedViewModel(mockRepository, get())
            viewModel.start()
            Assert.assertEquals(data, viewModel.tweeterFeedLiveData.value)
        }

    @Test
    fun whenAppStartedAndLoadDataCheckIfIfErrorFlagIsFalse() =
        runBlocking {
            val mockRepository = mock<TweeterFeedRepository>()
            given(mockRepository.getStatuses()).willReturn(data)
            viewModel = TweeterFeedViewModel(mockRepository, get())
            viewModel.start()
            Assert.assertEquals(false, viewModel.errorLiveData.value)
        }

    @Test
    fun whenAppStartedAndLoadDataAndIsErrorThenDataIsEmpty() =
        runBlocking {
            val mockRepository = mock<TweeterFeedRepository>()
            given(mockRepository.getStatuses()).willThrow(Throwable())
            viewModel = TweeterFeedViewModel(mockRepository, get())
            viewModel.start()
            Assert.assertEquals(emptyList<Tweet>(), viewModel.tweeterFeedLiveData.value)
        }

    @Test
    fun whenAppStartedAndLoadDataCheckIfIfErrorFlagIsTrue() =
        runBlocking {
            val mockRepository = mock<TweeterFeedRepository>()
            given(mockRepository.getStatuses()).willThrow(Throwable())
            viewModel = TweeterFeedViewModel(mockRepository, get())
            viewModel.start()
            Assert.assertEquals(true, viewModel.errorLiveData.value)
        }
}