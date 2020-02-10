package mvt.co.uk.tweeterfeed.presentation.tweeterFeed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mvt.co.uk.tweeterfeed.domain.model.Tweet
import mvt.co.uk.tweeterfeed.repository.TweeterFeedRepository
import org.koin.core.KoinComponent
import timber.log.Timber

class TweeterFeedViewModel(val repository: TweeterFeedRepository) : ViewModel(),
    KoinComponent {

    val tweeterFeedLiveData = MutableLiveData<List<Tweet>>()
    val errorLiveData = MutableLiveData<Boolean>()

    fun start() {
        loadData()
    }

    fun loadData() {
        errorLiveData.postValue(false)
        CoroutineScope(Dispatchers.IO).launch {
            var feedList = emptyList<Tweet>()
            try {
                feedList = repository.getStatuses()
            } catch (e: Throwable) {
                Timber.e("Exception ${e.message}")
                withContext(Dispatchers.Main) {
                    errorLiveData.value = true
                }
            }
            withContext(Dispatchers.Main) {
                try {
                    tweeterFeedLiveData.value = feedList
                } catch (e: Throwable) {
                    Timber.e("Exception ${e.message}")
                }
            }
        }
    }
}
