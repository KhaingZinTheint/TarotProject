package com.example.tarotproject

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tarotproject.databinding.FragmentMeditateBinding

class MeditateFragment : Fragment() {

    private var _binding: FragmentMeditateBinding? = null
    private val binding get() = _binding!!

    private var timer: CountDownTimer? = null
    private var isTimerRunning = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMeditateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize button listener
        binding.button.setOnClickListener {
            if (isTimerRunning) {
                stopTimer()
            } else {
                startTimer()
            }
        }
    }

    private fun startTimer() {
        isTimerRunning = true
        binding.button.text = "Stop"
        timer = object : CountDownTimer(900000, 1000) {  // 15 minutes = 900000 milliseconds
            override fun onTick(millisUntilFinished: Long) {
                val minutes = millisUntilFinished / 60000
                val seconds = (millisUntilFinished % 60000) / 1000
                binding.timeTv.text = String.format("%02d:%02d", minutes, seconds)
            }

            override fun onFinish() {
                stopTimer()
            }
        }.start()
    }

    private fun stopTimer() {
        timer?.cancel()
        binding.timeTv.text = "15:00"
        binding.button.text = "Start"
        isTimerRunning = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer?.cancel()
        _binding = null
    }
}
