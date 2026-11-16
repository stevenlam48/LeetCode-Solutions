package minimumsubsequenceinnonincreasingorder

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSubsequenceInNonIncreasingOrderTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(10, 9), Solution().minSubsequence(intArrayOf(4, 3, 10, 9, 8)))
    }

    @Test
    fun strictMajorityRequiresThirdElement() {
        assertArrayEquals(intArrayOf(7, 7, 6), Solution().minSubsequence(intArrayOf(4, 4, 7, 6, 7)))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(6), Solution().minSubsequence(intArrayOf(6)))
    }

    @Test
    fun equalElementsRequireWholeArray() {
        assertArrayEquals(intArrayOf(1, 1), Solution().minSubsequence(intArrayOf(1, 1)))
    }
}
