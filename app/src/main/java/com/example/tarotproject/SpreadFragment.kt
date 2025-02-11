package com.example.tarotproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tarotproject.databinding.FragmentSpreadBinding

class SpreadFragment : Fragment(R.layout.fragment_spread) {
    private lateinit var binding: FragmentSpreadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpreadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = listOf(
            SpreadItem(R.drawable.time, "Daily Reading", "A special reading that gives you guidance for the day ahead.", R.color.yellow),
            SpreadItem(R.drawable.week, "Weekly Reading", "Offers insights and advice tailored for your entire week.", R.color.ocean_blue),
            SpreadItem(R.drawable.cards, "Three Cards", "A versatile past,present,future reading that provides insight and guidance.", R.color.green1),
            SpreadItem(R.drawable.relationship, "Relationship", "Reveals insights into what brings you together, and pulls you apart.", R.color.violet),
            SpreadItem(R.drawable.angel, "Angel Message", "What your angels want to tell you right now?Offers you important messages.", R.color.pink),
            SpreadItem(R.drawable.finance, "Money & Career", "Focus on financial matters,helping you navigate important decisions.", R.color.yellow),
            SpreadItem(R.drawable.thinking, "Yes No", "Provides a clear, concise answer to a specific yes or no question.", R.color.ocean_blue),
            SpreadItem(R.drawable.heart, "Romance", "Offers guidance and insights into current or potential relationships.", R.color.green1),
            SpreadItem(R.drawable.rose, "New Love", "Offers insights into the prospects of a new romantic interest or relationship.", R.color.red),
            SpreadItem(R.drawable.crystal_ball, "What is your calling?", "An introspective reading aimed at helping you discover your true purpose.", R.color.pink),
        )

        val adapter = MyAdapter(R.layout.spread_item, items) { item, view ->
            val imageView = view.findViewById<ImageView>(R.id.item_image)
            val titleView = view.findViewById<TextView>(R.id.item_title)
            val descriptionView = view.findViewById<TextView>(R.id.item_description)
            val rootLayout = view.findViewById<androidx.cardview.widget.CardView>(R.id.rootLayout)

            imageView.setImageResource(item.image)
            titleView.text = item.title
            descriptionView.text = item.description
            rootLayout.setCardBackgroundColor(ContextCompat.getColor(requireContext(), item.backgroundColor))
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }
}
