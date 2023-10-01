package com.example.main

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.main.databinding.ActivityInfoBinding


class InfoActivity: AppCompatActivity(){
    lateinit var binding: ActivityInfoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInfoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragment_popup = InfoPopupFragment()

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        binding.btnIv.setOnClickListener {

            supportFragmentManager.beginTransaction().replace(R.id.popup_fl, fragment_popup).commit()
            window.statusBarColor = ContextCompat.getColor(this, R.color.translucent_gray)
        }

        binding.pwBoxCl.setOnClickListener {
            val intent = Intent(this, PwModifyActivity::class.java)
            startActivity(intent)
        }

        binding.nickBoxCl.setOnClickListener {
            binding.nickBoxIv.setImageResource(R.drawable.info_nick_error)
            binding.nickSubTv.text = "중복된 닉네임입니다"
            binding.nickSubTv.setTextColor(Color.parseColor("#E13017"))
        }

        binding.backIv.setOnClickListener {
            finish()
        }
    }

    fun changeFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .remove(fragment)
            .commit()
    }
}