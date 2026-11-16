package findthekthsmallestsumofamatrixwithsortedrows

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheKthSmallestSumOfAMatrixWithSortedRowsTest {
    @Test
    fun example1() {
        val mat = arrayOf(intArrayOf(1, 3, 11), intArrayOf(2, 4, 6))
        assertEquals(7, Solution().kthSmallest(mat, 5))
    }

    @Test
    fun example2() {
        val mat = arrayOf(intArrayOf(1, 3, 11), intArrayOf(2, 4, 6))
        assertEquals(17, Solution().kthSmallest(mat, 9))
    }

    @Test
    fun example3() {
        val mat = arrayOf(
            intArrayOf(1, 10, 10),
            intArrayOf(1, 4, 5),
            intArrayOf(2, 3, 6)
        )
        assertEquals(9, Solution().kthSmallest(mat, 7))
    }

    @Test
    fun singleCell() {
        assertEquals(1, Solution().kthSmallest(arrayOf(intArrayOf(1)), 1))
    }
}
