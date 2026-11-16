package validtrianglenumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidTriangleNumberTest {
    @Test
    fun leetCodeExampleOne() {
        assertEquals(3, Solution().triangleNumber(intArrayOf(2, 2, 3, 4)))
    }

    @Test
    fun leetCodeExampleTwo() {
        assertEquals(4, Solution().triangleNumber(intArrayOf(4, 2, 3, 4)))
    }

    @Test
    fun zerosNeverFormTriangles() {
        assertEquals(0, Solution().triangleNumber(intArrayOf(0, 0, 0)))
    }

    @Test
    fun allEqualSides() {
        assertEquals(4, Solution().triangleNumber(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun degenerateAndShortInputs() {
        assertEquals(0, Solution().triangleNumber(intArrayOf(1, 2, 3)))
        assertEquals(0, Solution().triangleNumber(intArrayOf()))
        assertEquals(0, Solution().triangleNumber(intArrayOf(2)))
    }
}
