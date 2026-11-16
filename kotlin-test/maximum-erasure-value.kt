package maximumerasurevalue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumErasureValueTest {
    @Test
    fun example1() {
        assertEquals(17, Solution().maximumUniqueSubarray(intArrayOf(4, 2, 4, 5, 6)))
    }

    @Test
    fun example2() {
        assertEquals(8, Solution().maximumUniqueSubarray(intArrayOf(5, 2, 1, 2, 5, 2, 1, 2, 5)))
    }

    @Test
    fun singleElement() {
        assertEquals(7, Solution().maximumUniqueSubarray(intArrayOf(7)))
    }

    @Test
    fun allSame() {
        assertEquals(1, Solution().maximumUniqueSubarray(intArrayOf(1, 1, 1)))
    }

    @Test
    fun allDistinct() {
        assertEquals(10, Solution().maximumUniqueSubarray(intArrayOf(1, 2, 3, 4)))
    }
}
