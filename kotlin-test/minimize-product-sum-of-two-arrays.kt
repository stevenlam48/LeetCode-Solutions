package minimizeproductsumoftwoarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeProductSumOfTwoArraysTest {
    @Test
    fun firstExample() {
        assertEquals(
            40,
            Solution().minProductSum(intArrayOf(5, 3, 4, 2), intArrayOf(4, 2, 2, 5))
        )
    }

    @Test
    fun secondExample() {
        assertEquals(
            29,
            Solution().minProductSum(intArrayOf(2, 1, 4, 3, 5), intArrayOf(3, 2, 4, 1, 2))
        )
    }

    @Test
    fun singleElement() {
        assertEquals(21, Solution().minProductSum(intArrayOf(7), intArrayOf(3)))
    }

    @Test
    fun duplicatesAndZero() {
        assertEquals(
            8,
            Solution().minProductSum(intArrayOf(0, 2, 2, 5), intArrayOf(2, 2, 3, 0))
        )
    }

    @Test
    fun emptyArrays() {
        assertEquals(0, Solution().minProductSum(intArrayOf(), intArrayOf()))
    }
}
