package minimumabsolutedifference

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAbsoluteDifferenceTest {
    private fun assertMatrix(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun example1() {
        val actual = Solution().minimumAbsDifference(intArrayOf(4, 2, 1, 3))
        val expected = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4))
        assertMatrix(expected, actual)
    }

    @Test
    fun example2() {
        val actual = Solution().minimumAbsDifference(intArrayOf(1, 3, 6, 10, 15))
        assertMatrix(arrayOf(intArrayOf(1, 3)), actual)
    }

    @Test
    fun example3() {
        val actual = Solution().minimumAbsDifference(intArrayOf(3, 8, -10, 23, 19, -4, -14, 27))
        val expected = arrayOf(intArrayOf(-14, -10), intArrayOf(19, 23), intArrayOf(23, 27))
        assertMatrix(expected, actual)
    }

    @Test
    fun twoElements() {
        assertMatrix(arrayOf(intArrayOf(1, 2)), Solution().minimumAbsDifference(intArrayOf(2, 1)))
    }

    @Test
    fun duplicates() {
        assertMatrix(arrayOf(intArrayOf(1, 1)), Solution().minimumAbsDifference(intArrayOf(1, 1)))
    }
}
