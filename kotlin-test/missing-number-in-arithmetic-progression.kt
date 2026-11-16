package missingnumberinarithmeticprogression

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MissingNumberInArithmeticProgressionTest {
    private val solution = Solution()

    @Test
    fun findsMissingValueInIncreasingProgression() {
        assertEquals(9, solution.missingNumber(intArrayOf(5, 7, 11, 13)))
    }

    @Test
    fun findsMissingValueInDecreasingProgression() {
        assertEquals(14, solution.missingNumber(intArrayOf(15, 13, 12)))
    }

    @Test
    fun findsMissingValueNearBeginning() {
        assertEquals(3, solution.missingNumber(intArrayOf(1, 2, 4)))
    }

    @Test
    fun handlesNegativeValues() {
        assertEquals(-2, solution.missingNumber(intArrayOf(10, 4, -8)))
    }
}
