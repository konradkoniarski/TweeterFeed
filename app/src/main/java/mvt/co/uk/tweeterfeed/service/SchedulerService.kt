package mvt.co.uk.tweeterfeed.service

import kotlin.coroutines.CoroutineContext

/**
 * Copyright (c) 2020 Mobile Vision Technologies LTD. All rights reserved.
 * Created on 2020-02-10.
 */
interface SchedulerService {
    val Main: CoroutineContext
    val IO: CoroutineContext
}