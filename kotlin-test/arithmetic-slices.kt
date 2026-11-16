package arithmeticslices

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ArithmeticSlicesTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(3, solution.numberOfArithmeticSlices(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun longerArithmeticArray() {
        assertEquals(6, solution.numberOfArithmeticSlices(intArrayOf(1, 3, 5, 7, 9)))
    }

    @Test
    fun separateArithmeticRuns() {
        assertEquals(2, solution.numberOfArithmeticSlices(intArrayOf(1, 2, 3, 8, 9, 10)))
    }

    @Test
    fun noArithmeticSlice() {
        assertEquals(0, solution.numberOfArithmeticSlices(intArrayOf(1, 2, 4)))
    }

    @Test
    fun fewerThanThreeElements() {
        assertEquals(0, solution.numberOfArithmeticSlices(IntArray(0)))
        assertEquals(0, solution.numberOfArithmeticSlices(intArrayOf(1, 1)))
    }
}
