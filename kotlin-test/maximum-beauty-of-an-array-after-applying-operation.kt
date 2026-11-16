package maximumbeautyofanarrayafterapplyingoperation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumBeautyOfAnArrayAfterApplyingOperationTest {
    @Test
    fun example() {
        assertEquals(3, Solution().maximumBeauty(intArrayOf(4, 6, 1, 2), 2))
    }

    @Test
    fun allEqual() {
        assertEquals(4, Solution().maximumBeauty(intArrayOf(1, 1, 1, 1), 10))
    }

    @Test
    fun zeroRange() {
        assertEquals(1, Solution().maximumBeauty(intArrayOf(1, 2, 3, 4), 0))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().maximumBeauty(intArrayOf(1), 0))
    }
}
