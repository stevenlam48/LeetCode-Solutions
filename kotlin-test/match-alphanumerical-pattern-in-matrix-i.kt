package matchalphanumericalpatterninmatrixi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MatchAlphanumericalPatternInMatrixITest {
    @Test
    fun testMappingMatch() {
        assertArrayEquals(
            intArrayOf(0, 0),
            Solution().findPattern(
                arrayOf(intArrayOf(1, 2), intArrayOf(2, 2)),
                listOf("ab", "bb")
            )
        )
    }

    @Test
    fun testDigitsMatch() {
        assertArrayEquals(
            intArrayOf(0, 0),
            Solution().findPattern(
                arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)),
                listOf("1a", "3b")
            )
        )
    }

    @Test
    fun testAllDistinctMapping() {
        assertArrayEquals(
            intArrayOf(0, 0),
            Solution().findPattern(
                arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)),
                listOf("ab", "cd")
            )
        )
    }

    @Test
    fun testNoMatch() {
        assertArrayEquals(
            intArrayOf(-1, -1),
            Solution().findPattern(
                arrayOf(intArrayOf(1, 2), intArrayOf(2, 1)),
                listOf("aa", "aa")
            )
        )
    }

    @Test
    fun testSingleRowSliding() {
        assertArrayEquals(
            intArrayOf(0, 0),
            Solution().findPattern(arrayOf(intArrayOf(1, 2, 1)), listOf("ab"))
        )
    }

    @Test
    fun testSingleCellMismatch() {
        assertArrayEquals(
            intArrayOf(-1, -1),
            Solution().findPattern(arrayOf(intArrayOf(5)), listOf("7"))
        )
    }
}
