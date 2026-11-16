package findifarraycanbesorted

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindIfArrayCanBeSortedTest {
    @Test
    fun standardExample() {
        assertTrue(Solution().canSortArray(intArrayOf(8, 4, 2, 30, 15)))
    }

    @Test
    fun alreadySorted() {
        assertTrue(Solution().canSortArray(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun impossible() {
        assertFalse(Solution().canSortArray(intArrayOf(3, 16, 8, 4, 2)))
    }

    @Test
    fun differentBitCountsCannotSwap() {
        assertFalse(Solution().canSortArray(intArrayOf(20, 16)))
    }

    @Test
    fun singleElement() {
        assertTrue(Solution().canSortArray(intArrayOf(1)))
    }
}
