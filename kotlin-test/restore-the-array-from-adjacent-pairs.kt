package restorethearrayfromadjacentpairs

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RestoreTheArrayFromAdjacentPairsTest {
    private fun assertRestored(expected: IntArray, actual: IntArray) {
        assertTrue(
            actual.contentEquals(expected) || actual.contentEquals(expected.reversedArray()),
            "expected ${expected.toList()} or its reverse, got ${actual.toList()}"
        )
    }

    @Test
    fun example1() {
        assertRestored(
            intArrayOf(1, 2, 3, 4),
            Solution().restoreArray(arrayOf(intArrayOf(2, 1), intArrayOf(3, 4), intArrayOf(3, 2)))
        )
    }

    @Test
    fun example2() {
        assertRestored(
            intArrayOf(-3, -9, 8, -2),
            Solution().restoreArray(arrayOf(intArrayOf(-3, -9), intArrayOf(-9, 8), intArrayOf(8, -2)))
        )
    }

    @Test
    fun singlePair() {
        assertRestored(
            intArrayOf(1, 2),
            Solution().restoreArray(arrayOf(intArrayOf(1, 2)))
        )
    }

    @Test
    fun negativeValues() {
        assertRestored(
            intArrayOf(4, -1, 3, 2),
            Solution().restoreArray(arrayOf(intArrayOf(4, -1), intArrayOf(-1, 3), intArrayOf(3, 2)))
        )
    }

    @Test
    fun outOfOrderPairs() {
        assertRestored(
            intArrayOf(100000, 5, 7, 3, 9),
            Solution().restoreArray(
                arrayOf(
                    intArrayOf(9, 3),
                    intArrayOf(3, 7),
                    intArrayOf(7, 5),
                    intArrayOf(5, 100000)
                )
            )
        )
    }
}
