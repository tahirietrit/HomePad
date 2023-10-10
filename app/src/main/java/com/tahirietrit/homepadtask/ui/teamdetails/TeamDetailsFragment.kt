package com.tahirietrit.homepadtask.ui.teamdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tahirietrit.homepadtask.databinding.FragmentTeamDetailsBinding
import com.tahirietrit.homepadtask.ui.SharedViewModel

class TeamDetailsFragment : Fragment() {

    private lateinit var binding: FragmentTeamDetailsBinding
    private lateinit var viewModel: SharedViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTeamDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        viewModel.selectedTeam.observe(viewLifecycleOwner){
            with(binding){
                teamLogo.setImageResource(it.logo)
                teamNameTextView.text = it.name
                teamCityTextView.text = it.city
                coachNameTextView.text = it.coachName
                pointsTextView.text = it.points.toString()
            }
        }
    }
}