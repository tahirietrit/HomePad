package com.tahirietrit.homepadtask.ui.teamstandings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tahirietrit.homepadtask.databinding.ItemTeamBinding
import com.tahirietrit.homepadtask.model.Team

class TeamListAdapter (private val onItemClick: (Team) -> Unit) :
    ListAdapter<Team, TeamListAdapter.TeamViewHolder>(TeamDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = getItem(position)
        holder.bind(team)
    }

    inner class TeamViewHolder(private val binding: ItemTeamBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val team = getItem(position)
                    onItemClick(team)
                }
            }
        }

        fun bind(team: Team) {
            binding.apply {
                // Bind team properties to UI elements
                teamNameTextView.text = team.name
                pointsTextView.text = "Points: ${team.points}"
                // Bind other team attributes as needed
            }
        }
    }

    private class TeamDiffCallback : DiffUtil.ItemCallback<Team>() {
        override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem.name == newItem.name // Assuming teams have unique IDs
        }

        override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem == newItem
        }
    }
}