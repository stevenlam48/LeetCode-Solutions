package numberofzigzagarraysi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfZigzagArraysITest {
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
    fun repeatedValuesAllowed() {
        assertEquals(28, Solution().zigZagArrays(3, 1, 4))
    }
}
