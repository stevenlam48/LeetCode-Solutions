package largesttrianglearea

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestTriangleAreaTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            2.0,
            solution.largestTriangleArea(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(0, 1),
                    intArrayOf(1, 0),
                    intArrayOf(0, 2),
                    intArrayOf(2, 0)
                )
            ),
            1e-9
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            0.5,
            solution.largestTriangleArea(
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 0),
                    intArrayOf(0, 1)
                )
            ),
            1e-9
        )
    }

    @Test
    fun testCollinearPoints() {
        assertEquals(
            0.0,
            solution.largestTriangleArea(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(1, 1),
                    intArrayOf(2, 2)
                )
            ),
            1e-9
        )
    }

    @Test
    fun testTooFewPoints() {
        assertEquals(
            0.0,
            solution.largestTriangleArea(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(1, 1)
                )
            ),
            1e-9
        )
    }

    @Test
    fun testLargerTriangle() {
        assertEquals(
            5.5,
            solution.largestTriangleArea(
                arrayOf(
                    intArrayOf(4, 6),
                    intArrayOf(6, 5),
                    intArrayOf(3, 1)
                )
            ),
            1e-9
        )
    }
}
