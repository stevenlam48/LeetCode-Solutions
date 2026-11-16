package altandtabsimulation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AltAndTabSimulationTest {
    @Test
    fun testExample1() {
        assertEquals(
            listOf(2, 3, 1),
            Solution().simulationResult(intArrayOf(1, 2, 3), intArrayOf(3, 3, 2))
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            listOf(2, 1, 3, 4),
            Solution().simulationResult(intArrayOf(1, 2, 4, 3), intArrayOf(3, 1, 2))
        )
    }

    @Test
    fun testNoQueries() {
        assertEquals(
            listOf(1, 2, 3),
            Solution().simulationResult(intArrayOf(1, 2, 3), intArrayOf())
        )
    }

    @Test
    fun testSingleWindow() {
        assertEquals(
            listOf(1),
            Solution().simulationResult(intArrayOf(1), intArrayOf(1))
        )
    }
}
