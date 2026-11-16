package twosum

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TwoSumTest {
    @Test
    fun example() {
        assertArrayEquals(intArrayOf(0, 1), Solution().twoSum(intArrayOf(2, 7, 11, 15), 9))
    }

    @Test
    fun laterPair() {
        assertArrayEquals(intArrayOf(1, 2), Solution().twoSum(intArrayOf(3, 2, 4), 6))
    }

    @Test
    fun duplicates() {
        assertArrayEquals(intArrayOf(0, 1), Solution().twoSum(intArrayOf(3, 3), 6))
    }
}