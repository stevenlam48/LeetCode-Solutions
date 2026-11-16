package findxvalueofarrayi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindXValueOfArrayITest {
    @Test
    fun example() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        assertArrayEquals(longArrayOf(9, 2, 4), Solution().resultArray(nums, 3))
    }

    @Test
    fun evenProducts() {
        val nums = intArrayOf(2, 4, 6, 8)
        assertArrayEquals(longArrayOf(8, 0, 2, 0), Solution().resultArray(nums, 4))
    }

    @Test
    fun modulusOne() {
        val nums = intArrayOf(5, 7)
        assertArrayEquals(longArrayOf(3), Solution().resultArray(nums, 1))
    }

    @Test
    fun zeroProducts() {
        val nums = intArrayOf(0, 2, 4)
        assertArrayEquals(longArrayOf(3, 1, 2), Solution().resultArray(nums, 3))
    }

    @Test
    fun emptyInput() {
        assertArrayEquals(longArrayOf(0, 0, 0), Solution().resultArray(intArrayOf(), 3))
    }
}
