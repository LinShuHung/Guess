package com.suhun.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.suhun.guess.databinding.ActivityMainBinding

private lateinit var binding:ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.hello.text = "TEST"
    }
}