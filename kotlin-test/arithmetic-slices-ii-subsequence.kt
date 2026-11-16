package arithmeticslicesiisubsequence

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ArithmeticSlicesIiSubsequenceTest {
    private val solution = Solution()

    @Test
    fun standardArithmeticExample() {
        assertEquals(7, solution.numberOfArithmeticSlices(intArrayOf(2, 4, 6, 8, 10)))
    }

    @Test
    fun repeatedValues() {
        assertEquals(16, solution.numberOfArithmeticSlices(intArrayOf(7, 7, 7, 7, 7)))
    }

    @Test
    fun decreasingSubsequence() {
        assertEquals(3, solution.numberOfArithmeticSlices(intArrayOf(3, 2, 1, 0)))
    }

    @Test
    fun differencesDoNotOverflowInt() {
        assertEquals(
            0,
            solution.numberOfArithmeticSlices(intArrayOf(Int.MIN_VALUE, 0, Int.MAX_VALUE))
        )
    }
}
