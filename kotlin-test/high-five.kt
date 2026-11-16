package highfive

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HighFiveTest {
    @Test
    fun standardExample() {
        val items = arrayOf(
            intArrayOf(1, 91), intArrayOf(1, 92), intArrayOf(2, 93),
            intArrayOf(2, 97), intArrayOf(1, 60), intArrayOf(2, 77),
            intArrayOf(1, 65), intArrayOf(1, 87), intArrayOf(1, 100),
            intArrayOf(2, 100), intArrayOf(2, 76)
        )

        assertHighFiveEquals(arrayOf(intArrayOf(1, 87), intArrayOf(2, 88)), Solution().highFive(items))
    }

    @Test
    fun fewerThanFiveScoresUsesAllScores() {
        val items = arrayOf(intArrayOf(1, 100), intArrayOf(1, 80), intArrayOf(2, 70))

        assertHighFiveEquals(arrayOf(intArrayOf(1, 90), intArrayOf(2, 70)), Solution().highFive(items))
    }

    @Test
    fun duplicateScoresAreKept() {
        val items = arrayOf(
            intArrayOf(1, 100), intArrayOf(1, 100), intArrayOf(1, 90),
            intArrayOf(1, 90), intArrayOf(1, 80), intArrayOf(1, 70)
        )

        assertHighFiveEquals(arrayOf(intArrayOf(1, 92)), Solution().highFive(items))
    }

    @Test
    fun resultIsSortedByStudentId() {
        val items = arrayOf(intArrayOf(2, 50), intArrayOf(1, 60))

        assertHighFiveEquals(arrayOf(intArrayOf(1, 60), intArrayOf(2, 50)), Solution().highFive(items))
    }

    @Test
    fun emptyInput() {
        assertHighFiveEquals(emptyArray(), Solution().highFive(emptyArray()))
    }
}

private fun assertHighFiveEquals(expected: Array<IntArray>, actual: Array<IntArray>) {
    assertEquals(expected.size, actual.size)
    for (i in expected.indices) {
        assertArrayEquals(expected[i], actual[i])
    }
}
