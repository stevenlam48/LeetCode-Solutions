package numberofdifferentsubsequencesgcds

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfDifferentSubsequencesGcdsTest {
    @Test
    fun example1() {
        assertEquals(5, Solution().countDifferentSubsequenceGCDs(intArrayOf(6, 10, 3)))
    }

    @Test
    fun example2() {
        assertEquals(7, Solution().countDifferentSubsequenceGCDs(intArrayOf(5, 15, 40, 5, 6)))
    }

    @Test
    fun oneElement() {
        assertEquals(1, Solution().countDifferentSubsequenceGCDs(intArrayOf(3)))
    }

    @Test
    fun pairAndTripleGcdsAreCountedOnce() {
        assertEquals(4, Solution().countDifferentSubsequenceGCDs(intArrayOf(12, 18, 24)))
    }

    @Test
    fun oneDominatesEveryCombinedGcd() {
        assertEquals(3, Solution().countDifferentSubsequenceGCDs(intArrayOf(1, 100, 200)))
    }
}
