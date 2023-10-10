package com.tahirietrit.homepadtask.model

data class Fixture(
    val homeTeam: Team,
    val awayTeam: Team,
    var homeGoals: Int = 0,
    var awayGoals: Int = 0
) {

    fun getWinner(): Team? {
        return when {
            homeGoals > awayGoals -> homeTeam
            awayGoals > homeGoals -> awayTeam
            else -> null
        }
    }
}
