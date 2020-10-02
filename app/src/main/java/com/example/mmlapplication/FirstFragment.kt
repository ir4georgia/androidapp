package com.example.mmlapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.*
import com.google.android.gms.ads.doubleclick.PublisherAdRequest
import com.google.android.gms.ads.doubleclick.PublisherAdView

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        val mPublisherAdView300x50 : PublisherAdView = view.findViewById(R.id.publisherAdView_300x50)
//        mPublisherAdView300x50.setManualImpressionsEnabled(true)
        mPublisherAdView300x50.setAdSizes(AdSize(300, 50))


        val mPublisherAdView300x250 : PublisherAdView = view.findViewById(R.id.publisherAdView_300x250)
        //mPublisherAdView300x250.setManualImpressionsEnabled(true)
        //mPublisherAdView300x250.setAdSizes(AdSize(300, 250))


        val adRequest300x50 = PublisherAdRequest.Builder()
            .addCustomTargeting("pos", "bnr_atf_01")
            .addCustomTargeting("appmode", "test")
            .build()

        val adRequest300x250 = PublisherAdRequest.Builder()
            .addCustomTargeting("pos", "rect_atf_01")
            .addCustomTargeting("appmode", "test")
            .build()

        mPublisherAdView300x50.loadAd(adRequest300x50)
        mPublisherAdView300x250.loadAd(adRequest300x250)

    }
}