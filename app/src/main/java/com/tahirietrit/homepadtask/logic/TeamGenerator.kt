package com.tahirietrit.homepadtask.logic

import com.tahirietrit.homepadtask.R
import com.tahirietrit.homepadtask.model.Team

object TeamGenerator {
    private val teamNames = listOf(
        "Team A", "Team B", "Team C", "Team D", "Team E",
        "Team F", "Team G", "Team H", "Team I", "Team J",
        "Team K", "Team L", "Team M", "Team N", "Team O",
        "Team P", "Team Q", "Team R", "Team S", "Team T"
    )

    private val coaches = listOf(
        "Coach Name 1", "Coach Name 2", "Coach Name 3", "Coach Name 4", "Coach Name 5",
    )

    private val cities = listOf(
        "City 1", "City 2", "City 3", "City 4", "City 5",
    )

    private val logos = listOf(
        R.drawable.real_madrid_c_f, R.drawable.sao_paulo_f_c
    )

    fun generateTeams(): List<Team> {
        val teams = mutableListOf<Team>()

        val shuffledTeamNames = teamNames.shuffled()

        for (i in 0 until 20) {
            val teamName = shuffledTeamNames[i]
            val points = 0 // Initial points for all teams
            val logo = logos.random()
            val coachName = coaches.random()
            val city = cities.random()

            val team = Team(teamName, points, logo, coachName, city)
            teams.add(team)
        }

        return teams
    }
}
