package maximumnumberofdartsinsideofacirculardartboard

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfDartsInsideOfACircularDartboardTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(
            4,
            solution.numPoints(
                arrayOf(
                    intArrayOf(-2, 0),
                    intArrayOf(2, 0),
                    intArrayOf(0, 2),
                    intArrayOf(0, -2)
                ),
                2
            )
        )
    }

    @Test
    fun exampleTwo() {
        assertEquals(
            4,
            solution.numPoints(
                arrayOf(
                    intArrayOf(-3, 0),
                    intArrayOf(3, 0),
                    intArrayOf(0, 3),
                    intArrayOf(0, -3)
                ),
                3
            )
        )
    }

    @Test
    fun singlePoint() {
        assertEquals(1, solution.numPoints(arrayOf(intArrayOf(0, 0)), 1))
    }

    @Test
    fun twoClosePoints() {
        assertEquals(
            2,
            solution.numPoints(arrayOf(intArrayOf(0, 0), intArrayOf(1, 0)), 1)
        )
    }

    @Test
    fun twoFarPoints() {
        assertEquals(
            1,
            solution.numPoints(arrayOf(intArrayOf(0, 0), intArrayOf(3, 0)), 1)
        )
    }

    @Test
    fun diameterPoints() {
        assertEquals(
            2,
            solution.numPoints(arrayOf(intArrayOf(0, 0), intArrayOf(2, 0)), 1)
        )
    }
}
