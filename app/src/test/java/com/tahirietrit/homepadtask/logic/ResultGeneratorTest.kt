package com.tahirietrit.homepadtask.logic

import com.tahirietrit.homepadtask.model.Fixture
import com.tahirietrit.homepadtask.model.Team
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ResultGeneratorTest {
    private lateinit var fixtures: List<Fixture>

    @Before
    fun setup() {
        val team1 = Team("Team1", 0, 0, "Text Coach", "Test city")
        val team2 = Team("Team2", 0, 0, "Text Coach", "Test city")
        fixtures = listOf(
            Fixture(team1, team2),
            Fixture(team2, team1)
        )
    }

    @Test
    fun testGenerateResults() {
        ResultGenerator.generateResults(fixtures)

        for (fixture in fixtures) {
            assertTrue(fixture.homeGoals in 0..5)
            assertTrue(fixture.awayGoals in 0..5)
        }
    }

    @Test
    fun testGenerateResultsPoints() {
        ResultGenerator.generateResults(fixtures)

        val team1 = fixtures[0].homeTeam
        val team2 = fixtures[0].awayTeam
        val winner = fixtures[0].getWinner()

        if (winner != null) {
            assertEquals(3, winner.points)
        } else {
            assertEquals(1, team1.points)
            assertEquals(1, team2.points)
        }
    }

    @Test
    fun testGenerateResultsMultipleFixtures() {
        val team3 = Team("Team3", 0, 0, "Text Coach", "Test city")
        val team4 = Team("Team4", 0, 0, "Text Coach", "Test city")
        val additionalFixtures = listOf(
            Fixture(team3, team4),
            Fixture(team4, team3)
        )

        val allFixtures = fixtures + additionalFixtures

        ResultGenerator.generateResults(allFixtures)

        for (fixture in allFixtures) {
            assertTrue(fixture.homeGoals in 0..5)
            assertTrue(fixture.awayGoals in 0..5)
        }
    }
}
