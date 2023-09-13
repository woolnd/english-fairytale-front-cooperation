package com.example.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.main.databinding.ActivityCommunityBinding
import com.sothree.slidinguppanel.SlidingUpPanelLayout

class CommunityActivity: AppCompatActivity() {

    lateinit var binding: ActivityCommunityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommunityBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.slideupSl.addPanelSlideListener(PanelEventListener())

        window.statusBarColor = ContextCompat.getColor(this, R.color.community_basic)
        binding.back1Iv.setOnClickListener {
            finish()
        }

        binding.back2Iv.setOnClickListener {
            finish()
        }
    }
    // 이벤트 리스너
    inner class PanelEventListener : SlidingUpPanelLayout.PanelSlideListener {
        // 패널이 슬라이드 중일 때
        override fun onPanelSlide(panel: View?, slideOffset: Float) {
        }

        // 패널의 상태가 변했을 때
        override fun onPanelStateChanged(panel: View?, previousState: SlidingUpPanelLayout.PanelState?, newState: SlidingUpPanelLayout.PanelState?) {
            if (newState == SlidingUpPanelLayout.PanelState.COLLAPSED) {
                window.statusBarColor = ContextCompat.getColor(this@CommunityActivity, R.color.community_basic)
                binding.headerCl.visibility = View.GONE
            } else if (newState == SlidingUpPanelLayout.PanelState.EXPANDED) {
                window.statusBarColor = ContextCompat.getColor(this@CommunityActivity, R.color.community_gray)
                binding.headerCl.visibility = View.VISIBLE
            }
        }
    }
}