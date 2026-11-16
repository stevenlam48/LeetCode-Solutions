package rotatefunction

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RotateFunctionTest {
    @Test
    fun leetCodeExample() {
        assertEquals(26, Solution().maxRotateFunction(intArrayOf(4, 3, 2, 6)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().maxRotateFunction(intArrayOf(100)))
    }

    @Test
    fun ascendingValues() {
        assertEquals(8, Solution().maxRotateFunction(intArrayOf(1, 2, 3)))
    }

    @Test
    fun negativeValues() {
        assertEquals(-1, Solution().maxRotateFunction(intArrayOf(-1, -2)))
    }

    @Test
    fun allZeros() {
        assertEquals(0, Solution().maxRotateFunction(intArrayOf(0, 0, 0)))
    }
}
