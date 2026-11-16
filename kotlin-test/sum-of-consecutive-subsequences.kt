package sumofconsecutivesubsequences

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfConsecutiveSubsequencesTest {
    @Test
    fun twoElements() {
        assertEquals(6, Solution().getSum(intArrayOf(1, 2)))
    }

    @Test
    fun increasingArray() {
        assertEquals(20, Solution().getSum(intArrayOf(1, 2, 3)))
    }

    @Test
    fun brokenOrder() {
        assertEquals(14, Solution().getSum(intArrayOf(1, 3, 2)))
    }

    @Test
    fun duplicates() {
        assertEquals(2, Solution().getSum(intArrayOf(1, 1)))
    }
}
