package findtwononoverlappingsubarrayseachwithtargetsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTwoNonOverlappingSubArraysEachWithTargetSumTest {
    @Test
    fun exampleOne() {
        assertEquals(2, Solution().minSumOfLengths(intArrayOf(3, 2, 2, 4, 3), 3))
    }

    @Test
    fun exampleTwo() {
        assertEquals(2, Solution().minSumOfLengths(intArrayOf(7, 3, 4, 7), 7))
    }

    @Test
    fun noPair() {
        assertEquals(-1, Solution().minSumOfLengths(intArrayOf(1, 2, 3, 4), 10))
    }

    @Test
    fun equalLengthSubarrays() {
        assertEquals(4, Solution().minSumOfLengths(intArrayOf(1, 1, 1, 1), 2))
    }
}
