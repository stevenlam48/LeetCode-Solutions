package maximumpulsevalueafteronesubarrayrotation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumPulseValueAfterOneSubarrayRotationTest {
    private val solution = Solution()

    @Test
    fun rotationImprovesNegativePulse() {
        assertEquals(2L, solution.maxValue(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun originalPulseIsAlreadyMaximum() {
        assertEquals(6L, solution.maxValue(intArrayOf(1, -2, 3)))
    }

    @Test
    fun negativeValues() {
        assertEquals(0L, solution.maxValue(intArrayOf(-1, -2, -3)))
    }

    @Test
    fun singleElement() {
        assertEquals(7L, solution.maxValue(intArrayOf(7)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0L, solution.maxValue(intArrayOf()))
    }
}
