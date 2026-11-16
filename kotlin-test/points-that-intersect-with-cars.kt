package pointsthatintersectwithcars

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PointsThatIntersectWithCarsTest {
    @Test
    fun overlappingIntervals() {
        assertEquals(
            7,
            Solution().numberOfPoints(arrayOf(intArrayOf(3, 6), intArrayOf(1, 5), intArrayOf(4, 7)))
        )
    }

    @Test
    fun disjointIntervals() {
        assertEquals(7, Solution().numberOfPoints(arrayOf(intArrayOf(1, 3), intArrayOf(5, 8))))
    }

    @Test
    fun containedInterval() {
        assertEquals(3, Solution().numberOfPoints(arrayOf(intArrayOf(1, 3), intArrayOf(2, 3))))
    }

    @Test
    fun touchingSinglePointIntervals() {
        assertEquals(4, Solution().numberOfPoints(arrayOf(intArrayOf(1, 2), intArrayOf(2, 4))))
    }
}
