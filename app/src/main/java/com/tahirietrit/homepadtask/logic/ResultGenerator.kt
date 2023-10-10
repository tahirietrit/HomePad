package com.tahirietrit.homepadtask.logic

import com.tahirietrit.homepadtask.model.Fixture
import kotlin.random.Random

object ResultGenerator {
    fun generateResults(fixtures: List<Fixture>) {
        for (fixture in fixtures) {
            val homeGoals = Random.nextInt(6)
            val awayGoals = Random.nextInt(6)

            fixture.homeGoals = homeGoals
            fixture.awayGoals = awayGoals

            val winner = fixture.getWinner()
            if (winner != null) {
                winner.points += 3
            } else {
                fixture.homeTeam.points += 1
                fixture.awayTeam.points += 1
            }
        }
    }
}
