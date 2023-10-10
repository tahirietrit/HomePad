import com.tahirietrit.homepadtask.logic.FixtureGenerator
import com.tahirietrit.homepadtask.model.Fixture
import com.tahirietrit.homepadtask.model.Team
import org.junit.Assert.*
import org.junit.Test

class FixtureGeneratorTest {

    @Test
    fun testGenerateFixtures() {
        val teams = listOf(
            Team("Team1", 0, 0, "Text Coach", "Test city"),
            Team("Team2", 0, 0, "Text Coach", "Test city"),
            Team("Team3", 0, 0, "Text Coach", "Test city"),
        )

        val fixtures = FixtureGenerator.generateFixtures(teams)

        assertEquals(6, fixtures.size)

        for (fixture in fixtures) {
            val homeTeam = fixture.homeTeam
            val awayTeam = fixture.awayTeam

            assertNotEquals(homeTeam, awayTeam)

            val complementaryFixture = Fixture(awayTeam, homeTeam)
            assertTrue(fixtures.contains(complementaryFixture))
        }
    }

    @Test
    fun testGenerateFixturesWithEmptyTeamList() {
        val teams = emptyList<Team>()
        val fixtures = FixtureGenerator.generateFixtures(teams)

        assertEquals(0, fixtures.size)
    }

    @Test
    fun testGenerateFixturesWithOneTeam() {
        val teams = listOf(
            Team("Team1", 0, 0, "Text Coach", "Test city"),
        )
        val fixtures = FixtureGenerator.generateFixtures(teams)

        assertEquals(0, fixtures.size)
    }

    @Test
    fun testGenerateFixturesWithTwoTeams() {
        val teams = listOf(
            Team("Team1", 0, 0, "Text Coach", "Test city"),
            Team("Team2", 0, 0, "Text Coach", "Test city"),
        )
        val fixtures = FixtureGenerator.generateFixtures(teams)

        assertEquals(2, fixtures.size)
    }
}
