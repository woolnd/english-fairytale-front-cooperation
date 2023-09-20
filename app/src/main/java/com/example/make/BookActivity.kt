package com.example.make

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.make.databinding.ActivityBookBinding

class BookActivity : AppCompatActivity() {
    lateinit var binding: ActivityBookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hearttitle.setOnClickListener {
            binding.heart.setImageResource(R.drawable.book_heart_after)
//          var heartcount = binding.heartcount.toString().toInt()
//          heartcount = 1
        }
        binding.english.setOnClickListener {
            binding.english.setImageResource(R.drawable.book_english_after)
        }
        binding.primary.setOnClickListener {
            binding.primary.setImageResource(R.drawable.book_primary_after)
        }
    }

}