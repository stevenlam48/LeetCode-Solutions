package sortarraybyabsolutevalue

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SortArrayByAbsoluteValueTest {
    @Test
    fun mixedSigns() {
        assertArrayEquals(
            intArrayOf(1, -2, 2, 3, -4, -5),
            Solution().sortByAbsoluteValue(intArrayOf(3, -2, 1, -5, 2, -4))
        )
    }

    @Test
    fun emptyArray() {
        assertArrayEquals(intArrayOf(), Solution().sortByAbsoluteValue(intArrayOf()))
    }

    @Test
    fun equalAbsoluteValuesKeepOrder() {
        assertArrayEquals(intArrayOf(2, -2), Solution().sortByAbsoluteValue(intArrayOf(2, -2)))
    }

    @Test
    fun zero() {
        assertArrayEquals(intArrayOf(0), Solution().sortByAbsoluteValue(intArrayOf(0)))
    }

    @Test
    fun allNegative() {
        assertArrayEquals(
            intArrayOf(-1, -2, -3),
            Solution().sortByAbsoluteValue(intArrayOf(-3, -1, -2))
        )
    }
}
