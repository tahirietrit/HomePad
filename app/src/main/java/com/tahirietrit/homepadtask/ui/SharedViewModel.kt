package com.tahirietrit.homepadtask.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tahirietrit.homepadtask.logic.FixtureGenerator
import com.tahirietrit.homepadtask.logic.ResultGenerator
import com.tahirietrit.homepadtask.logic.TeamGenerator
import com.tahirietrit.homepadtask.model.Fixture
import com.tahirietrit.homepadtask.model.Team

class SharedViewModel : ViewModel() {
    // List of teams  be shared among fragments
    private val _teams = MutableLiveData<List<Team>>()
    val teams: LiveData<List<Team>> = _teams

    private val _fixtures = MutableLiveData<List<Fixture>>()
    val fixtures: LiveData<List<Fixture>> = _fixtures

    var teamData = listOf<Team>()
    private var fixtureData = listOf<Fixture>()

    private val _selectedTeam = MutableLiveData<Team>()
    val selectedTeam: LiveData<Team> = _selectedTeam

    init {
        _teams.value = emptyList()
        teamData = TeamGenerator.generateTeams()
        fixtureData = FixtureGenerator.generateFixtures(teamData)
        _fixtures.value = fixtureData
    }

    private fun updateTeams(updatedTeams: List<Team>) {
        _teams.value = updatedTeams
    }

    fun setSelectedTeam(team: Team) {
        _selectedTeam.value = team
    }

    fun playGames() {
        ResultGenerator.generateResults(fixtureData)
        updateTeams( teamData.sortedByDescending { it.points })
    }

}