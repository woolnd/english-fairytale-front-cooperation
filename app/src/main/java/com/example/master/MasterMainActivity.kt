package com.example.master

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.master.databinding.ActivityMasterMainBinding

class MasterMainActivity: AppCompatActivity() {

    lateinit var binding: ActivityMasterMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMasterMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn1Cl.setOnClickListener {
            val intent = Intent(this, ReportNickActivity::class.java)
            startActivity(intent)
        }

        binding.btn2Cl.setOnClickListener {
            val intent = Intent(this, ReportPostActivity::class.java)
            startActivity(intent)
        }
    }
}