package positionsoflargegroups

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PositionsOfLargeGroupsTest {
    private fun assertGroups(expected: Array<IntArray>, input: String) {
        assertArrayEquals(expected, Solution().largeGroupPositions(input))
    }

    @Test
    fun groupsThroughoutString() {
        assertGroups(arrayOf(intArrayOf(3, 5), intArrayOf(8, 10)), "abbcccddeee")
    }

    @Test
    fun groupAtBeginning() {
        assertGroups(arrayOf(intArrayOf(0, 2)), "aaabbc")
    }

    @Test
    fun noLargeGroups() {
        assertGroups(emptyArray(), "abccdd")
    }

    @Test
    fun emptyString() {
        assertGroups(emptyArray(), "")
    }
}
