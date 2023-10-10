package com.tahirietrit.homepadtask.ui.teamgeneration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tahirietrit.homepadtask.R
import com.tahirietrit.homepadtask.databinding.FragmentTeamGenerationBinding
import com.tahirietrit.homepadtask.ui.SharedViewModel

class TeamGenerationFragment : Fragment() {
    private lateinit var binding: FragmentTeamGenerationBinding
    private lateinit var viewModel: SharedViewModel
    private lateinit var fixtureAdapter: FixtureAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamGenerationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        fixtureAdapter = FixtureAdapter()
        with(binding){
            playGames.setOnClickListener {
                viewModel.playGames()
                findNavController().navigate(R.id.navigateToTeamStandings)
            }
            fixtureList.apply {
                adapter = fixtureAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.fixtures.observe(viewLifecycleOwner){
            fixtureAdapter.submitList(it)
        }
    }
}
