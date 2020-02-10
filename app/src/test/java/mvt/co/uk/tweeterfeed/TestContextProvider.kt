package mvt.co.uk.tweeterfeed

import kotlinx.coroutines.Dispatchers
import mvt.co.uk.tweeterfeed.service.SchedulerService
import org.koin.core.KoinComponent
import kotlin.coroutines.CoroutineContext

/**
 * Copyright (c) 2020 Mobile Vision Technologies LTD. All rights reserved.
 * Created on 2020-02-10.
 */
class TestSchedulerService : SchedulerService, KoinComponent {
    override val Main: CoroutineContext = Dispatchers.Unconfined
    override val IO: CoroutineContext = Dispatchers.Unconfined
}