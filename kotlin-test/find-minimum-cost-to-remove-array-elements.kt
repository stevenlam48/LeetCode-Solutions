package findminimumcosttoremovearrayelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMinimumCostToRemoveArrayElementsTest {
    @Test
    fun example1() {
        assertEquals(12, Solution().minCost(intArrayOf(6, 2, 8, 4)))
    }

    @Test
    fun example2() {
        assertEquals(5, Solution().minCost(intArrayOf(2, 1, 3, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(5, Solution().minCost(intArrayOf(5)))
    }

    @Test
    fun twoElements() {
        assertEquals(2, Solution().minCost(intArrayOf(1, 2)))
    }

    @Test
    fun threeElements() {
        assertEquals(4, Solution().minCost(intArrayOf(1, 2, 3)))
    }

    @Test
    fun allEqual() {
        assertEquals(4, Solution().minCost(intArrayOf(2, 2, 2, 2)))
    }
}
