package kthmissingpositivenumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthMissingPositiveNumberTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(9, solution.findKthPositive(intArrayOf(2, 3, 4, 7, 11), 5))
    }

    @Test
    fun example2() {
        assertEquals(6, solution.findKthPositive(intArrayOf(1, 2, 3, 4), 2))
    }

    @Test
    fun singleOne() {
        assertEquals(2, solution.findKthPositive(intArrayOf(1), 1))
    }

    @Test
    fun startsAtTwo() {
        assertEquals(1, solution.findKthPositive(intArrayOf(2), 1))
    }

    @Test
    fun beyondArray() {
        assertEquals(5, solution.findKthPositive(intArrayOf(1, 2), 3))
    }

    @Test
    fun firstMissing() {
        assertEquals(1, solution.findKthPositive(intArrayOf(2, 3, 4, 7, 11), 1))
    }
}
