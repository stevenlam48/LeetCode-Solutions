package numberofzigzagarraysiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfZigzagArraysIIITest {
    @Test
    fun directDpWithTwoValues() {
        assertEquals(2, Solution().zigZagArrays(3, 4, 5))
    }

    @Test
    fun directDpWithFourPositions() {
        assertEquals(16, Solution().zigZagArrays(4, 1, 3))
    }

    @Test
    fun interpolationWithThreePositions() {
        assertEquals(60, Solution().zigZagArrays(3, 1, 5))
    }

    @Test
    fun interpolationWithFourPositions() {
        assertEquals(170, Solution().zigZagArrays(4, 1, 5))
    }
}
