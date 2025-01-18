package org.acad.presentation.screens.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.acad.presentation.databinding.ItemOnboardingBinding
import org.acad.presentation.screens.onboarding.Adapter.ViewHolder

/**
 * Created by Acad Bek on 12/30/2024
 */
class Adapter(
    private val items: List<Pair<Int, String>>
): RecyclerView.Adapter<ViewHolder>() {

    inner class ViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item: Pair<Int, String>) {
                binding.avatar.setImageResource(item.first)
                binding.txt.text = item.second
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOnboardingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}