package anglesofatriangle

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals

class AnglesOfATriangleTest {
    private val solution = Solution()

    @Test
    fun equilateralTriangle() {
        val angles = solution.internalAngles(intArrayOf(5, 5, 5))
        assertEquals(3, angles.size)
        for (angle in angles) {
            assertEquals(60.0, angle, 1e-9)
        }
    }

    @Test
    fun rightTriangleAndInputSorting() {
        val sides = intArrayOf(5, 3, 4)
        val angles = solution.internalAngles(sides)
        assertArrayEquals(intArrayOf(3, 4, 5), sides)
        assertArrayEquals(
            doubleArrayOf(36.86989764584402, 53.13010235415598, 90.0),
            angles,
            1e-9
        )
    }

    @Test
    fun degenerateTriangleHasNoAngles() {
        assertEquals(0, solution.internalAngles(intArrayOf(1, 2, 3)).size)
    }

    @Test
    fun cannotFormTriangle() {
        assertEquals(0, solution.internalAngles(intArrayOf(1, 1, 3)).size)
    }
}
