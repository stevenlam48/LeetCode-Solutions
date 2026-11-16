package findchampionii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindChampionIiTest {
    @Test
    fun uniqueUndefeatedTeam() {
        assertEquals(0, Solution().findChampion(3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))))
    }

    @Test
    fun multipleUndefeatedTeams() {
        val edges = arrayOf(intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(1, 2))
        assertEquals(-1, Solution().findChampion(4, edges))
    }

    @Test
    fun singleTeamWithoutEdges() {
        assertEquals(0, Solution().findChampion(1, emptyArray()))
    }
}
