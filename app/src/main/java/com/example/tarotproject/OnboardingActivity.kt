package com.example.tarotproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.tarotproject.databinding.ActivityOnboardingBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator


class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var dotsIndicator: DotsIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAdapter = OnboardingAdapter(this)
        binding.myViewPager.adapter = myAdapter

        dotsIndicator = binding.dotsIndicator
        dotsIndicator.attachTo(binding.myViewPager)
    }
}