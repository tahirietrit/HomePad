package com.tahirietrit.homepadtask.logic

import com.tahirietrit.homepadtask.model.Fixture
import com.tahirietrit.homepadtask.model.Team

object FixtureGenerator {
    fun generateFixtures(teams: List<Team>): List<Fixture> {
        val fixtures = mutableListOf<Fixture>()

        for (i in teams.indices) {
            for (j in i + 1 until teams.size) {
                val homeTeam = teams[i]
                val awayTeam = teams[j]
                val homeFixture = Fixture(homeTeam, awayTeam)
                val awayFixture = Fixture(awayTeam, homeTeam)
                fixtures.add(homeFixture)
                fixtures.add(awayFixture)
            }
        }

        return fixtures
    }
}