package productoftworunlengthencodedarrays

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProductOfTwoRunLengthEncodedArraysTest {
    private val solution = Solution()

    private fun check(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun validCase1_alignedRuns() {
        val actual = solution.findRLEArray(
            arrayOf(intArrayOf(1, 3), intArrayOf(2, 3)),
            arrayOf(intArrayOf(6, 3), intArrayOf(3, 3))
        )
        check(arrayOf(intArrayOf(6, 6)), actual)
    }

    @Test
    fun validCase2_partiallyAlignedRuns() {
        val actual = solution.findRLEArray(
            arrayOf(intArrayOf(1, 3), intArrayOf(2, 1), intArrayOf(3, 2)),
            arrayOf(intArrayOf(2, 3), intArrayOf(3, 1), intArrayOf(5, 2))
        )
        check(arrayOf(intArrayOf(2, 3), intArrayOf(6, 1), intArrayOf(15, 2)), actual)
    }

    @Test
    fun validCase3_splitRuns() {
        val actual = solution.findRLEArray(
            arrayOf(intArrayOf(1, 5)),
            arrayOf(intArrayOf(2, 2), intArrayOf(3, 3))
        )
        check(arrayOf(intArrayOf(2, 2), intArrayOf(3, 3)), actual)
    }

    @Test
    fun validCase4_mergeEqualProducts() {
        val actual = solution.findRLEArray(
            arrayOf(intArrayOf(1, 2), intArrayOf(3, 2)),
            arrayOf(intArrayOf(3, 2), intArrayOf(1, 2))
        )
        check(arrayOf(intArrayOf(3, 4)), actual)
    }

    @Test
    fun validCase5_zeroProduct() {
        val actual = solution.findRLEArray(
            arrayOf(intArrayOf(0, 2), intArrayOf(2, 1)),
            arrayOf(intArrayOf(3, 2), intArrayOf(4, 1))
        )
        check(arrayOf(intArrayOf(0, 2), intArrayOf(8, 1)), actual)
    }

    @Test
    fun validCase6_singleRuns() {
        val actual = solution.findRLEArray(
            arrayOf(intArrayOf(4, 1)),
            arrayOf(intArrayOf(5, 1))
        )
        check(arrayOf(intArrayOf(20, 1)), actual)
    }
}
