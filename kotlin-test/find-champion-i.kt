package findchampioni

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindChampionITest {
    @Test
    fun twoTeams() {
        assertEquals(0, Solution().findChampion(arrayOf(intArrayOf(0, 1), intArrayOf(0, 0))))
    }

    @Test
    fun threeTeams() {
        val grid = arrayOf(intArrayOf(0, 0, 1), intArrayOf(1, 0, 1), intArrayOf(0, 0, 0))
        assertEquals(1, Solution().findChampion(grid))
    }

    @Test
    fun noChampion() {
        assertEquals(-1, Solution().findChampion(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))))
    }
}
