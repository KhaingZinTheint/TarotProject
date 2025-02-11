package com.example.tarotproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyHomeAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        // Number of fragments/pages
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        // Return the appropriate fragment for each position
        return when (position) {
            0 -> SpreadFragment()
            1 -> MeditateFragment()
            2 -> HistoryFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}