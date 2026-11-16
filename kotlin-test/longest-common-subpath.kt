package longestcommonsubpath

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestCommonSubpathTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(
            2,
            solution.longestCommonSubpath(
                5,
                arrayOf(intArrayOf(0, 1, 2, 3, 4), intArrayOf(2, 3, 4), intArrayOf(4, 0, 1, 2, 3))
            )
        )
    }

    @Test
    fun repeatedValues() {
        assertEquals(
            3,
            solution.longestCommonSubpath(
                2,
                arrayOf(intArrayOf(1, 1, 1, 0), intArrayOf(0, 1, 1, 1), intArrayOf(1, 1, 1))
            )
        )
    }

    @Test
    fun singleElementPaths() {
        assertEquals(
            1,
            solution.longestCommonSubpath(1, arrayOf(intArrayOf(0), intArrayOf(0), intArrayOf(0)))
        )
    }

    @Test
    fun noCommonElement() {
        assertEquals(
            0,
            solution.longestCommonSubpath(3, arrayOf(intArrayOf(0, 1), intArrayOf(2, 1), intArrayOf(2, 0)))
        )
    }
}
