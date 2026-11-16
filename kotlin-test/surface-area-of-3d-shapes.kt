package surfaceareaof3dshapes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SurfaceAreaOf3dShapesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(34, solution.surfaceArea(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))))
    }

    @Test
    fun testExample2() {
        assertEquals(16, solution.surfaceArea(arrayOf(intArrayOf(1, 0), intArrayOf(0, 2))))
    }

    @Test
    fun testExample3() {
        assertEquals(
            32,
            solution.surfaceArea(
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 0, 1),
                    intArrayOf(1, 1, 1)
                )
            )
        )
    }

    @Test
    fun testExample4() {
        assertEquals(
            46,
            solution.surfaceArea(
                arrayOf(
                    intArrayOf(2, 2, 2),
                    intArrayOf(2, 1, 2),
                    intArrayOf(2, 2, 2)
                )
            )
        )
    }

    @Test
    fun testSingleCell() {
        assertEquals(6, solution.surfaceArea(arrayOf(intArrayOf(1))))
    }
}
