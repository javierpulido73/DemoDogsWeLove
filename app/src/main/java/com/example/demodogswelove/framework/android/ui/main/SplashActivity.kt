package com.example.demodogswelove.framework.android.ui.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.demodogswelove.databinding.ActivitySplashBinding
import com.example.demodogswelove.framework.android.ui.dogs.DogsOverviewActivity

/**
 * Created by Javier Pulido on 17/junio/2022
 */
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    companion object {
        private const val SPLASH_TIME = 3000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, DogsOverviewActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME)
    }
}