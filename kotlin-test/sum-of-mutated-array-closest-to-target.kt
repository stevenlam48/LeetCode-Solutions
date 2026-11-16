package sumofmutatedarrayclosesttotarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfMutatedArrayClosestToTargetTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(3, solution.findBestValue(intArrayOf(4, 9, 3), 10))
    }

    @Test
    fun secondExample() {
        assertEquals(5, solution.findBestValue(intArrayOf(2, 3, 5), 10))
    }

    @Test
    fun targetAboveTotalReturnsMaximum() {
        assertEquals(3, solution.findBestValue(intArrayOf(1, 2, 3), 100))
    }

    @Test
    fun zeroTargetReturnsZero() {
        assertEquals(0, solution.findBestValue(intArrayOf(4, 9, 3), 0))
    }

    @Test
    fun tiesUseSmallerValue() {
        assertEquals(0, solution.findBestValue(intArrayOf(1, 1), 1))
    }
}
