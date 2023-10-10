package com.tahirietrit.homepadtask.ui.teamstandings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tahirietrit.homepadtask.R
import com.tahirietrit.homepadtask.databinding.FragmentTeamStandingsBinding
import com.tahirietrit.homepadtask.ui.SharedViewModel

class TeamStandingsFragment : Fragment() {
    private lateinit var binding: FragmentTeamStandingsBinding
    private lateinit var viewModel: SharedViewModel
    private lateinit var teamListAdapter: TeamListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamStandingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        teamListAdapter = TeamListAdapter { selectedTeam ->
            viewModel.setSelectedTeam(selectedTeam)
            findNavController().navigate(R.id.navigateToTeamDetails)
        }

        binding.teamStandingsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = teamListAdapter
        }
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.teams.observe(viewLifecycleOwner, Observer { teams ->
            teamListAdapter.submitList(teams)
        })
    }
}