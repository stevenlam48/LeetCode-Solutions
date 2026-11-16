package typeoftriangleii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TypeOfTriangleIiTest {
    @Test
    fun equilateral() {
        assertEquals("equilateral", Solution().triangleType(intArrayOf(3, 3, 3)))
    }

    @Test
    fun scalene() {
        assertEquals("scalene", Solution().triangleType(intArrayOf(3, 4, 5)))
    }

    @Test
    fun isosceles() {
        assertEquals("isosceles", Solution().triangleType(intArrayOf(3, 3, 4)))
    }

    @Test
    fun none() {
        assertEquals("none", Solution().triangleType(intArrayOf(1, 2, 3)))
    }
}
