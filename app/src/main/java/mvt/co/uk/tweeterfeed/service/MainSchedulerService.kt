package mvt.co.uk.tweeterfeed.service

import kotlinx.coroutines.Dispatchers
import org.koin.core.KoinComponent
import kotlin.coroutines.CoroutineContext

/**
 * Copyright (c) 2020 Mobile Vision Technologies LTD. All rights reserved.
 * Created on 2020-02-10.
 */
open class MainSchedulerService : SchedulerService, KoinComponent {
    override val Main: CoroutineContext by lazy { Dispatchers.Main }
    override val IO: CoroutineContext by lazy { Dispatchers.IO }
}