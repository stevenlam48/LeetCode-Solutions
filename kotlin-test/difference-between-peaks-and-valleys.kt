package differencebetweenpeaksandvalleys

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DifferenceBetweenPeaksAndValleysTest {
    @Test
    fun testExample1() {
        assertEquals(3, Solution().peakValleyDifference(intArrayOf(1, 2, 1, 2, 1)))
    }

    @Test
    fun testExample2() {
        assertEquals(3, Solution().peakValleyDifference(intArrayOf(1, 3, 1)))
    }

    @Test
    fun testNoPeaksOrValleys() {
        assertEquals(0, Solution().peakValleyDifference(intArrayOf(1, 2, 3, 4)))
        assertEquals(0, Solution().peakValleyDifference(intArrayOf(4, 3, 2, 1)))
    }

    @Test
    fun testShortInput() {
        assertEquals(0, Solution().peakValleyDifference(intArrayOf()))
        assertEquals(0, Solution().peakValleyDifference(intArrayOf(5)))
        assertEquals(0, Solution().peakValleyDifference(intArrayOf(5, 1)))
    }

    @Test
    fun testMultiplePeaksAndValleys() {
        assertEquals(9, Solution().peakValleyDifference(intArrayOf(1, 5, 1, 5, 1)))
    }
}
