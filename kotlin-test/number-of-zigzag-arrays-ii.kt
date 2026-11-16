package numberofzigzagarraysii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfZigzagArraysIITest {
    @Test
    fun twoValues() {
        assertEquals(2, Solution().zigZagArrays(3, 4, 5))
    }

    @Test
    fun threeValues() {
        assertEquals(10, Solution().zigZagArrays(3, 1, 3))
    }

    @Test
    fun fourPositions() {
        assertEquals(16, Solution().zigZagArrays(4, 1, 3))
    }

    @Test
    fun widerRange() {
        assertEquals(170, Solution().zigZagArrays(4, 1, 5))
    }
}
