package com.tahirietrit.homepadtask.ui.teamgeneration

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tahirietrit.homepadtask.databinding.ItemFixtureBinding
import com.tahirietrit.homepadtask.model.Fixture

class FixtureAdapter :
    ListAdapter<Fixture, FixtureAdapter.FixtureViewHolder>(TeamDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixtureViewHolder {
        val binding = ItemFixtureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FixtureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FixtureAdapter.FixtureViewHolder, position: Int) {
        val team = getItem(position)
        holder.bind(team)
    }

    inner class FixtureViewHolder(private val binding: ItemFixtureBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(fixture: Fixture) {
            binding.apply {
                homeTeamTextView.text = fixture.homeTeam.name
                homeTeamLogo.setImageResource(fixture.homeTeam.logo)
                awayTeamTextView.text = fixture.awayTeam.name
                awayTeamLogo.setImageResource(fixture.awayTeam.logo)
            }
        }
    }

    private class TeamDiffCallback : DiffUtil.ItemCallback<Fixture>() {
        override fun areItemsTheSame(oldItem: Fixture, newItem: Fixture): Boolean {
            return oldItem.awayTeam == newItem.awayTeam // Assuming teams have unique IDs
        }

        override fun areContentsTheSame(oldItem: Fixture, newItem: Fixture): Boolean {
            return oldItem == newItem
        }
    }
}