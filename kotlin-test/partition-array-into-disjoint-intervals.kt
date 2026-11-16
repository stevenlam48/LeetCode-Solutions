package partitionarrayintodisjointintervals

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PartitionArrayIntoDisjointIntervalsTest {
    @Test
    fun testExampleOne() {
        assertEquals(3, Solution().partitionDisjoint(intArrayOf(5, 0, 3, 8, 6)))
    }

    @Test
    fun testExampleTwo() {
        assertEquals(4, Solution().partitionDisjoint(intArrayOf(1, 1, 1, 0, 6, 12)))
    }

    @Test
    fun testTwoElementsIncreasing() {
        assertEquals(1, Solution().partitionDisjoint(intArrayOf(1, 2)))
    }

    @Test
    fun testTwoEqualElements() {
        assertEquals(1, Solution().partitionDisjoint(intArrayOf(1, 1)))
    }

    @Test
    fun testPartitionAtSecondIndex() {
        assertEquals(1, Solution().partitionDisjoint(intArrayOf(1, 2, 3, 4, 5)))
    }
}
