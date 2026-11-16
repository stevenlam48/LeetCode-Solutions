package maximumfrequencyaftersubarrayoperation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumFrequencyAfterSubarrayOperationTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().maxFrequency(intArrayOf(1, 2, 3, 4, 5, 6), 1))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().maxFrequency(intArrayOf(10, 2, 3, 4, 5, 5, 4, 3, 2, 2), 10))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().maxFrequency(intArrayOf(1), 1))
    }

    @Test
    fun allTarget() {
        assertEquals(4, Solution().maxFrequency(intArrayOf(3, 3, 3, 3), 3))
    }

    @Test
    fun noTarget() {
        assertEquals(1, Solution().maxFrequency(intArrayOf(1, 2, 3), 5))
    }
}
