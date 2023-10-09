package com.example.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.main.databinding.ActivitySearchBinding

class SearchActivity: AppCompatActivity() {
    lateinit var binding: ActivitySearchBinding
    lateinit var tab1: SearchFragment
    lateinit var tab2: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySearchBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        tab1 = SearchFragment()
        tab2 = MainFragment()

        supportFragmentManager.beginTransaction().add(R.id.search_fl, tab1).commit()

        binding.filterLeftIv.setOnClickListener {
            replaceView(tab1)
        }

        binding.filterRightIv.setOnClickListener {
            replaceView(tab2)
        }
    }

    private fun replaceView(tab: Fragment){
        var selectorFragment: Fragment? = null
        selectorFragment = tab
        selectorFragment?.let{
            supportFragmentManager.beginTransaction()
                .replace(R.id.search_fl, it).commit()
        }
    }
}