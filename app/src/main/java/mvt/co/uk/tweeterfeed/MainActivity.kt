package mvt.co.uk.tweeterfeed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mvt.co.uk.tweeterfeed.presentation.tweeterFeed.TweeterFeedFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TweeterFeedFragment.newInstance())
                .commitNow()
        }
    }

}
