package com.example.make

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.media.session.MediaSession.Token
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.make.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.gray)

        binding.randomMakeBtnIv.setOnClickListener {
            val intent = Intent(this, LoadingActivity::class.java)
            startActivity(intent)
        }

        // ToKen list and print text
        val list = listOf(binding.token1Cl, binding.token2Cl, binding.token3Cl, binding.token4Cl,binding.token5Cl)
        val list2 = listOf(binding.token1,binding.token2,binding.token3,binding.token4,binding.token5)


        binding.addChipBoxIv.setOnClickListener {
            val text = binding.editText.text.toString()

            if (text.toString() == "") Toast.makeText(application,"텍스트를 입력해주세요",Toast.LENGTH_SHORT).show()
            else {
                binding.editText.setText(null)
                var check = 0

                for (i in 0..4) {
                    if (list[i].visibility == View.GONE) break
                    else check += 1
                }

                if (check < 5) {
                    list[check].visibility = View.VISIBLE
                    list2[check].text = text
                    binding.mainCreateBtn.setImageResource(R.drawable.make_book_btn)
                    binding.mainCreateBtn.setOnClickListener {
                        val intent = Intent(this, LoadingActivity::class.java)
                        startActivity(intent)
                    }
                }
            }

        }

        // if click close button, token close
        binding.close1.setOnClickListener {
            binding.token1Cl.visibility = View.GONE
            var check_button = 0
            for (i in 0..4) {
                if (list[i].visibility != View.GONE) check_button = 1
            }
            if (check_button == 0) binding.mainCreateBtn.setImageResource(R.drawable.main_create_button)
        }
        binding.close2.setOnClickListener {
            binding.token2Cl.visibility = View.GONE
            var check_button = 0
            for (i in 0..4) {
                if (list[i].visibility != View.GONE) check_button = 1
            }
            if (check_button == 0) binding.mainCreateBtn.setImageResource(R.drawable.main_create_button)
        }
        binding.close3.setOnClickListener {
            binding.token3Cl.visibility = View.GONE
            var check_button = 0
            for (i in 0..4) {
                if (list[i].visibility != View.GONE) check_button = 1
            }
            if (check_button == 0) binding.mainCreateBtn.setImageResource(R.drawable.main_create_button)
        }
        binding.close4.setOnClickListener {
            binding.token4Cl.visibility = View.GONE
            var check_button = 0
            for (i in 0..4) {
                if (list[i].visibility != View.GONE) check_button = 1
            }
            if (check_button == 0) binding.mainCreateBtn.setImageResource(R.drawable.main_create_button)
        }
        binding.close5.setOnClickListener {
            binding.token5Cl.visibility = View.GONE
            var check_button = 0
            for (i in 0..4) {
                if (list[i].visibility != View.GONE) check_button = 1
            }
            if (check_button == 0) binding.mainCreateBtn.setImageResource(R.drawable.main_create_button)
        }


        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var text = binding.editText.text.toString()
                if(verifyId(text)){
                    binding.addChipBoxIv.setImageResource(R.drawable.add_button_box_after)
                }
                else{
                    binding.addChipBoxIv.setImageResource(R.drawable.add_button_box)
                }

            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })



    }

    fun verifyId(id: String) : Boolean {
        val regexId = """^[a-z]{1,15}$""".toRegex()
        return regexId.matches(id)
    }


}