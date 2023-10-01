package com.example.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.main.databinding.ActivityPwModifyBinding

class PwModifyActivity: AppCompatActivity() {

    lateinit var binding: ActivityPwModifyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPwModifyBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragment_popup = PwModifyPopupFragment()

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

        binding.btnIv.setOnClickListener {

            supportFragmentManager.beginTransaction().replace(R.id.popup_fl, fragment_popup).commit()
            window.statusBarColor = ContextCompat.getColor(this, R.color.translucent_gray)
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