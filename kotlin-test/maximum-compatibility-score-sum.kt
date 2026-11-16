package maximumcompatibilityscoresum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumCompatibilityScoreSumTest {
    @Test
    fun example() {
        assertEquals(
            8,
            Solution().maxCompatibilitySum(
                arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 0, 1), intArrayOf(0, 0, 1)),
                arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 0, 1), intArrayOf(1, 1, 0))
            )
        )
    }

    @Test
    fun noMatches() {
        assertEquals(
            0,
            Solution().maxCompatibilitySum(
                arrayOf(intArrayOf(0, 0), intArrayOf(0, 0), intArrayOf(0, 0)),
                arrayOf(intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(1, 1))
            )
        )
    }

    @Test
    fun twoStudents() {
        assertEquals(
            2,
            Solution().maxCompatibilitySum(
                arrayOf(intArrayOf(1, 0), intArrayOf(0, 1)),
                arrayOf(intArrayOf(1, 0), intArrayOf(1, 0))
            )
        )
    }
}
