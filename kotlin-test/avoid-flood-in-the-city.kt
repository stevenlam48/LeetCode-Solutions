package avoidfloodinthecity

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AvoidFloodInTheCityTest {
    private val solution = Solution()

    @Test
    fun testNoDryDays() {
        assertArrayEquals(
            intArrayOf(-1, -1, -1, -1),
            solution.avoidFlood(intArrayOf(1, 2, 3, 4))
        )
    }

    @Test
    fun testDryDayAvailable() {
        assertArrayEquals(
            intArrayOf(-1, -1, 2, 1, -1, -1),
            solution.avoidFlood(intArrayOf(1, 2, 0, 0, 2, 1))
        )
    }

    @Test
    fun testImpossible() {
        assertArrayEquals(intArrayOf(), solution.avoidFlood(intArrayOf(1, 2, 0, 1, 2)))
        assertArrayEquals(
            intArrayOf(-1, -1, 2, 1, -1, -1),
            solution.avoidFlood(intArrayOf(1, 2, 0, 0, 2, 1))
        )
    }

    @Test
    fun testExampleWithSingleLake() {
        assertArrayEquals(
            intArrayOf(-1, 69, 1, 1, -1),
            solution.avoidFlood(intArrayOf(69, 0, 0, 0, 69))
        )
    }
}
