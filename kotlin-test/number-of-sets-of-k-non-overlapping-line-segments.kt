package numberofsetsofknonoverlappinglinesegments

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfSetsOfKNonOverlappingLineSegmentsTest {
    @Test
    fun testExample1() {
        assertEquals(5, Solution().numberOfSets(4, 2))
    }

    @Test
    fun testExample2() {
        assertEquals(3, Solution().numberOfSets(3, 1))
    }

    @Test
    fun testExample3() {
        assertEquals(796297179, Solution().numberOfSets(30, 7))
    }

    @Test
    fun testSinglePoint() {
        assertEquals(1, Solution().numberOfSets(2, 1))
    }
}
