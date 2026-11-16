package numberofwaystoweardifferenthatstoeachother

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToWearDifferentHatsToEachOtherTest {
    @Test
    fun forcedAssignment() {
        val hats = arrayOf(intArrayOf(3, 4), intArrayOf(4, 5), intArrayOf(5))
        assertEquals(1, Solution().numberWays(hats))
    }

    @Test
    fun twoPeople() {
        val hats = arrayOf(intArrayOf(3, 5, 1), intArrayOf(3, 5))
        assertEquals(4, Solution().numberWays(hats))
    }

    @Test
    fun identicalPreferences() {
        val hats = Array(4) { intArrayOf(1, 2, 3, 4) }
        assertEquals(24, Solution().numberWays(hats))
    }
}
