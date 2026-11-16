package sortarrayusingprefixreversals

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortArrayUsingPrefixReversalsTest {
    @Test
    fun alreadySorted() {
        assertEquals(0, Solution().sortArray(intArrayOf(0, 1, 2), intArrayOf(2, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().sortArray(intArrayOf(0), intArrayOf(1)))
    }

    @Test
    fun onePrefixReversal() {
        assertEquals(1, Solution().sortArray(intArrayOf(1, 0, 2), intArrayOf(2)))
        assertEquals(1, Solution().sortArray(intArrayOf(2, 1, 0), intArrayOf(2, 3)))
    }

    @Test
    fun multiplePrefixReversals() {
        assertEquals(2, Solution().sortArray(intArrayOf(2, 0, 1), intArrayOf(2, 3)))
    }

    @Test
    fun unreachableArrangement() {
        assertEquals(-1, Solution().sortArray(intArrayOf(1, 2, 0), intArrayOf(2)))
    }
}
