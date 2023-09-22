package com.example.make

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.accessibility.AccessibilityViewCommand.SetTextArguments
import com.example.make.databinding.ActivityBookBinding
import com.sothree.slidinguppanel.SlidingUpPanelLayout

class BookActivity : AppCompatActivity() {
    lateinit var binding: ActivityBookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.beforeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        window.statusBarColor = ContextCompat.getColor(this, R.color.gray)

//        val option_list = mutableListOf(0,0,0)
//        binding.mainFrame.addPanelSlideListener(PanelEventListener())
//
//        binding.hearttitle.setOnClickListener {
//            if (option_list[0] == 0) {
//                option_list[0] = 1
//                binding.heart.setImageResource(R.drawable.book_heart_after)
//                var counting = binding.heartcount.text.toString().toInt()
//                counting += 1
//                binding.heartcount.setText(counting.toString())
//            }
//            else {
//                option_list[0] = 0
//                binding.heart.setImageResource(R.drawable.book_heart)
//                var counting = binding.heartcount.text.toString().toInt()
//                counting -= 1
//                binding.heartcount.setText(counting.toString())
//            }
//        }
//        binding.english.setOnClickListener {
//            if (option_list[1] == 0) {
//                option_list[1] = 1
//                binding.english.setImageResource(R.drawable.book_english_after)
//            }
//            else {
//                option_list[1] = 0
//                binding.english.setImageResource(R.drawable.book_english)
//            }
//        }
//        binding.primary.setOnClickListener {
//            if (option_list[2] == 0) {
//                option_list[2] = 1
//                binding.primary.setImageResource(R.drawable.book_primary_after)
//            }
//            else {
//                option_list[2] = 0
//                binding.primary.setImageResource(R.drawable.book_primary)
//            }
//        }
//    }
//    inner class PanelEventListener : SlidingUpPanelLayout.PanelSlideListener{
//        override fun onPanelSlide(panel: View?, slideOffset: Float) {
//            TODO("Not yet implemented")
//        }
//
//        override fun onPanelStateChanged(
//            panel: View?,
//            previousState: SlidingUpPanelLayout.PanelState?,
//            newState: SlidingUpPanelLayout.PanelState?
//        ) {
//            TODO("Not yet implemented")
//        }
//
    }
}