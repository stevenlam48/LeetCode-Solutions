package twosumiiinputarrayissorted

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TwoSumIiInputArrayIsSortedTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(1, 2), Solution().twoSum(intArrayOf(2, 7, 11, 15), 9))
    }

    @Test
    fun example2() {
        assertArrayEquals(intArrayOf(1, 3), Solution().twoSum(intArrayOf(2, 3, 4), 6))
    }

    @Test
    fun negatives() {
        assertArrayEquals(intArrayOf(1, 2), Solution().twoSum(intArrayOf(-1, 0), -1))
    }

    @Test
    fun lastPair() {
        assertArrayEquals(intArrayOf(3, 4), Solution().twoSum(intArrayOf(1, 2, 3, 4), 7))
    }
}
