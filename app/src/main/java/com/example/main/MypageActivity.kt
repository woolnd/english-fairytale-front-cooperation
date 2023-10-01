package com.example.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.main.databinding.ActivityMypageBinding

class MypageActivity: AppCompatActivity() {

    lateinit var binding: ActivityMypageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMypageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

        binding.backIv.setOnClickListener {
            finish()
        }

        binding.infoBtnIv.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }

        binding.noticeIv.setOnClickListener {
            val intent = Intent(this, NotifyActivity::class.java)
            startActivity(intent)
        }

    }
}