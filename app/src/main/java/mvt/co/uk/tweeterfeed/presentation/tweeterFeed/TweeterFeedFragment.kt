package mvt.co.uk.tweeterfeed.presentation.tweeterFeed

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_tweeter_feed.*
import mvt.co.uk.tweeterfeed.R
import mvt.co.uk.tweeterfeed.databinding.FragmentTweeterFeedBinding
import mvt.co.uk.tweeterfeed.presentation.ItemsAdapter
import org.koin.android.ext.android.inject

class TweeterFeedFragment : Fragment() {

    companion object {
        fun newInstance() = TweeterFeedFragment()
    }

    val viewModel: TweeterFeedViewModel by inject()
    lateinit var binding: FragmentTweeterFeedBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_tweeter_feed, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.start()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.viewModel = viewModel

        val layoutManager = LinearLayoutManager(context)

        recycler_view_list_tweet.layoutManager = layoutManager
        recycler_view_list_tweet.hasFixedSize()
        recycler_view_list_tweet.adapter = ItemsAdapter()

        button_refresh.setOnClickListener {
            viewModel.loadData()
        }

    }
}
