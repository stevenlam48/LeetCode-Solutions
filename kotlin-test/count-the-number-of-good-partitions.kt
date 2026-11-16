package countthenumberofgoodpartitions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfGoodPartitionsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(8, solution.numberOfGoodPartitions(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.numberOfGoodPartitions(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun testExample3() {
        assertEquals(2, solution.numberOfGoodPartitions(intArrayOf(1, 2, 1, 3)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, solution.numberOfGoodPartitions(intArrayOf(7)))
    }

    @Test
    fun testTwoDistinct() {
        assertEquals(2, solution.numberOfGoodPartitions(intArrayOf(1, 2)))
    }
}
