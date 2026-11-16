package minimizearraysumusingdivisiblereplacements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeArraySumUsingDivisibleReplacementsTest {
    @Test
    fun allReplaceableByOne() {
        assertEquals(3L, Solution().minArraySum(intArrayOf(1, 2, 3)))
    }

    @Test
    fun replaceMultiplesOfTwo() {
        assertEquals(6L, Solution().minArraySum(intArrayOf(2, 4, 6)))
    }

    @Test
    fun replaceMultipleOfFive() {
        assertEquals(10L, Solution().minArraySum(intArrayOf(5, 10)))
    }

    @Test
    fun noProperDivisorPresent() {
        assertEquals(14L, Solution().minArraySum(intArrayOf(7, 7)))
    }

    @Test
    fun singleElement() {
        assertEquals(1L, Solution().minArraySum(intArrayOf(1)))
    }

    @Test
    fun chainedMultiples() {
        assertEquals(9L, Solution().minArraySum(intArrayOf(3, 9, 27)))
    }
}
