package maximumperformanceofateam

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPerformanceOfATeamTest {
    private val speed = intArrayOf(2, 10, 3, 1, 5, 8)
    private val efficiency = intArrayOf(5, 4, 3, 9, 7, 2)

    @Test
    fun twoEngineers() {
        assertEquals(60, Solution().maxPerformance(6, speed, efficiency, 2))
    }

    @Test
    fun threeEngineers() {
        assertEquals(68, Solution().maxPerformance(6, speed, efficiency, 3))
    }

    @Test
    fun oneEngineer() {
        assertEquals(40, Solution().maxPerformance(6, speed, efficiency, 1))
    }

    @Test
    fun smallTeam() {
        assertEquals(56, Solution().maxPerformance(3, intArrayOf(2, 8, 2), intArrayOf(2, 7, 1), 2))
    }
}
