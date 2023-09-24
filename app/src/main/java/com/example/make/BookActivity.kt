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
import kotlin.text.StringBuilder

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

        val option_list = mutableListOf(0,0,0)
        binding.mainFrame.addPanelSlideListener(PanelEventListener())

        binding.hearttitle.setOnClickListener {
            if (option_list[0] == 0) {
                option_list[0] = 1
                binding.heart.setImageResource(R.drawable.book_heart_after)
                var counting = binding.heartcount.text.toString().toInt()
                counting += 1
                binding.heartcount.setText(counting.toString())
            }
            else {
                option_list[0] = 0
                binding.heart.setImageResource(R.drawable.book_heart)
                var counting = binding.heartcount.text.toString().toInt()
                counting -= 1
                binding.heartcount.setText(counting.toString())
            }
        }
        binding.english.setOnClickListener {
            if (option_list[1] == 0) {
                option_list[1] = 1
                binding.english.setImageResource(R.drawable.book_english_after)
            }
            else {
                option_list[1] = 0
                binding.english.setImageResource(R.drawable.book_english)
            }
        }
        binding.primary.setOnClickListener {
            if (option_list[2] == 0) {
                option_list[2] = 1
                binding.primary.setImageResource(R.drawable.book_primary_after)
            }
            else {
                option_list[2] = 0
                binding.primary.setImageResource(R.drawable.book_primary)
            }
        }

        binding.beforeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        //api 호출 아래는 테스트용
        var text_eng = """A dog is walking down the street, when he sees a bone in a trash can. “A bone! Yippee! How lucky for me!” he thinks. He grabs the bone, and happily runs home. He runs past the train station and the school. He runs through the park. He runs onto a bridge. On the bridge, the dog looks down into the deep, still water below. There, he sees another dog with a bone in its mouth. “Who is that dog?” he wonders. "What is he doing down there?" The dog stares at the other dog. The other dog stares back. “Where did that dog get such a BIG bone?” the dog wonders. "Why is his bone bigger than mine?" The dog growls at the other dog. The other dog growls too. “I want that big bone!” he thinks. The greedy dog decides to steal the other dog's bone. He leaps off the bridge and into the water. Splash! But as soon as he hits the water, the other dog disappears. There was never any other dog. It was just his own reflection! The water is very deep and the dog is surprised. “Woof woof woof! Help!” he barks. And when he barks, his bone drops from his mouth — and sinks to the bottom of the water. The dog swims to shore. He is wet and cold, and now he has no bone at all."""
        var text_kor = "개가 길을 걷다가 쓰레기통에 있는 뼈를 발견했습니다. “뼈! 만세! 나한테는 정말 행운이었어!“그가 생가가했습니다.그는 뼈를 잡고 행복하게 집으로 달려갑니다.그는 기차역과 학교를 지나 달려갑니다. 그는 공원을 달리고 있다.그는 다리 위로 달려갑니다."

        var textList_eng = mutableListOf<String>()
        var sentence_eng = StringBuilder()
        var textList_kor = mutableListOf<String>()
        var sentence_kor = StringBuilder()

        for (i in text_eng) {
            sentence_eng.append(i)
            if ( i == '.') {
                sentence_eng.append("\n")
                textList_eng.add(sentence_eng.toString())
                sentence_eng = StringBuilder()
            }
        }

        for (i in text_kor) {
            sentence_kor.append(i)
            if(i== '.') {
                sentence_kor.append("\n")
                textList_kor.add(sentence_kor.toString())
                sentence_kor = StringBuilder()
            }
        }

        binding.textEngTv.text = textList_eng.joinToString("")


    }
    inner class PanelEventListener : SlidingUpPanelLayout.PanelSlideListener{
        override fun onPanelSlide(panel: View?, slideOffset: Float) {
        }

        override fun onPanelStateChanged(
            panel: View?,
            previousState: SlidingUpPanelLayout.PanelState?,
            newState: SlidingUpPanelLayout.PanelState?
        ) {
        }

    }
}