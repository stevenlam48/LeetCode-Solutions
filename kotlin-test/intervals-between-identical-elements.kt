package intervalsbetweenidenticalelements

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IntervalsBetweenIdenticalElementsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            longArrayOf(4, 2, 3, 2, 4, 3),
            solution.getDistances(intArrayOf(2, 1, 3, 1, 2, 3))
        )
    }

    @Test
    fun testExample2() {
        assertArrayEquals(
            longArrayOf(5, 0, 3, 4),
            solution.getDistances(intArrayOf(10, 5, 10, 10))
        )
    }

    @Test
    fun testSingleElement() {
        assertArrayEquals(longArrayOf(0), solution.getDistances(intArrayOf(7)))
    }

    @Test
    fun testAllSame() {
        assertArrayEquals(longArrayOf(3, 2, 3), solution.getDistances(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testAllDistinct() {
        assertArrayEquals(longArrayOf(0, 0, 0), solution.getDistances(intArrayOf(1, 2, 3)))
    }
}
