package maximumnumberofpotholesthatcanbefixed

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberofpotholesthatcanbefixedTest {
    @Test
    fun singleLongSegment() {
        assertEquals(3, Solution().maxPotholes("xxx", 4))
    }

    @Test
    fun twoSinglePotholes() {
        assertEquals(1, Solution().maxPotholes("x.x", 3))
    }

    @Test
    fun noPotholes() {
        assertEquals(0, Solution().maxPotholes("....", 5))
    }

    @Test
    fun mixedSegments() {
        assertEquals(3, Solution().maxPotholes("xx.x", 5))
    }

    @Test
    fun singlePotholeTightBudget() {
        assertEquals(0, Solution().maxPotholes("x", 1))
    }

    @Test
    fun longSegmentSmallBudget() {
        assertEquals(1, Solution().maxPotholes("xxxx", 2))
    }
}
