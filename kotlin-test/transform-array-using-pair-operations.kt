package transformarrayusingpairoperations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TransformArrayUsingPairOperationsTest {
    @Test
    fun equalSumsCanTransform() {
        assertTrue(Solution().canTransform(intArrayOf(1, 2, 3), intArrayOf(2, 2, 2)))
        assertTrue(Solution().canTransform(intArrayOf(-2, 5, 0), intArrayOf(3)))
    }

    @Test
    fun unequalSumsCannotTransform() {
        assertFalse(Solution().canTransform(intArrayOf(1, 2, 3), intArrayOf(1, 2, 4)))
    }

    @Test
    fun largeValuesUseLongSums() {
        assertTrue(Solution().canTransform(intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE), intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE)))
    }
}
