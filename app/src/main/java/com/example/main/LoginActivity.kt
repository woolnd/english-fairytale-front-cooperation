package com.example.main

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.main.databinding.ActivityLoginBinding
import java.util.regex.Pattern

class LoginActivity: AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.emailEt.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                val email = binding.emailEt.text.toString()
                val pw = binding.pwEt.text.toString()

                if(verifyEmail(email)){
                    binding.error1Tv.visibility = View.GONE
                    binding.input1Iv.setImageResource(R.drawable.reset_pw_box)
                }
                else{
                    binding.error1Tv.visibility = View.VISIBLE
                    binding.input1Iv.setImageResource(R.drawable.reset_pw_box_error)
                    binding.btnIv.setImageResource(R.drawable.info_btn_gray)
                    binding.btnTv.setTextColor(Color.parseColor("#5C5D61"))
                }
            }
        })

        binding.pwEt.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                val email = binding.emailEt.text.toString()
                val pw = binding.pwEt.text.toString()
                if(verifyPw(pw) && verifyEmail(email)){
                    binding.error2Tv.visibility = View.GONE
                    binding.input2Iv.setImageResource(R.drawable.reset_pw_box)
                    binding.btnIv.setImageResource(R.drawable.info_btn)
                    binding.btnTv.setTextColor(Color.parseColor("#FFFFFF"))

                    binding.btnTv.setOnClickListener {
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                    }
                }
                else{
                    binding.error2Tv.visibility = View.VISIBLE
                    binding.input2Iv.setImageResource(R.drawable.reset_pw_box_error)
                    binding.btnIv.setImageResource(R.drawable.info_btn_gray)
                    binding.btnTv.setTextColor(Color.parseColor("#5C5D61"))
                }
            }

        })

        binding.eyeOffIv.setOnClickListener {
            val currentImg = binding.eyeOffIv.drawable
            val eyeoff = ContextCompat.getDrawable(this, R.drawable.eye_off)
            val eyeon = ContextCompat.getDrawable(this, R.drawable.eye_on)
            if(currentImg != null && eyeoff != null && eyeon != null){
                if(areDrawablesEqual(currentImg, eyeoff)){
                    binding.eyeOffIv.setImageResource(R.drawable.eye_on)
                    binding.pwEt.inputType = InputType.TYPE_CLASS_TEXT
                }
                else if(areDrawablesEqual(currentImg, eyeon)){
                    binding.eyeOffIv.setImageResource(R.drawable.eye_off)
                    binding.pwEt.inputType =
                        InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                }
            }
        }

        binding.backIv.setOnClickListener {
            finish()
        }
    }

    fun verifyEmail(email: String): Boolean{
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        if(pattern.matcher(email).matches()){
            return true
        }
        else{
            return false
        }
    }

    fun verifyPw(pw: String): Boolean{
        val regexPw = """^(?=.*[a-zA-Z])(?=.*\d).{8,15}$""".toRegex()
        return regexPw.matches(pw)
    }

    fun areDrawablesEqual(drawable1: Drawable, drawable2: Drawable): Boolean {
        val bitmap1 = drawableToBitmap(drawable1)
        val bitmap2 = drawableToBitmap(drawable2)
        return bitmap1.sameAs(bitmap2)
    }


    // Drawable을 Bitmap으로 변환하는 함수
    fun drawableToBitmap(drawable: Drawable): Bitmap {
        if (drawable is BitmapDrawable) {
            return drawable.bitmap
        }

        val width = drawable.intrinsicWidth
        val height = drawable.intrinsicHeight

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)

        return bitmap
    }
}