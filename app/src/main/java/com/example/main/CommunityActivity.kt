package com.example.main

import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
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


        val best = arrayListOf<Books>(
            Books("hello","hello", arrayListOf("bio", "hello", "my name is jaewoong", "have a nice day", "hello"), false),
            Books("hello","hello hello hello hello", arrayListOf("nice too meet you", "hello", "bye", "bye"), true),
            Books("hello","hello hello hello hello", arrayListOf("nice too meet you", "hello", "bye", "bye"), true),
            Books("hello","hello hello hello hello", arrayListOf("nice too meet you", "hello", "bye", "bye"), true)
        )

        val books = arrayListOf<Books>(
            Books("hello","hello", arrayListOf("bio", "hello", "my name is jaewoong", "have a nice day", "hello"), false),
            Books("hello","hello hello hello hello", arrayListOf("nice too meet you", "hello", "bye", "bye"), true),
            Books("hello","hello hello hello hello", arrayListOf("nice too meet you", "hello", "bye", "bye"), true),
            Books("hello","hello hello hello hello", arrayListOf("nice too meet you", "hello", "bye", "bye"), true)
        )

        binding.bestRv.apply {
            adapter = BestAdapter().build(best)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        binding.communityRv.apply {
            adapter = CommunityAdapter().build(books)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        binding.filterIv.setOnClickListener {
            var filter = PopupMenu(applicationContext, it)

            menuInflater?.inflate(R.menu.filter, filter.menu)
            filter.show()
            filter.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.action_menu1 -> {
                        binding.communityTv.text = "친구들의 책 둘러보기"
                        return@setOnMenuItemClickListener true
                    }
                    R.id.action_menu2 -> {
                        binding.communityTv.text = "최근에 올라온 책"
                        return@setOnMenuItemClickListener true
                    }
                    R.id.action_menu3 -> {
                        binding.communityTv.text = "친구들이 가장 좋아한 책"
                        return@setOnMenuItemClickListener true
                    }
                    else -> {
                        return@setOnMenuItemClickListener true
                    }
                }
            }
        }
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