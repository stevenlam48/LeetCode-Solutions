package sumofallsubsetxortotals

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfAllSubsetXorTotalsTest {
    @Test
    fun exampleOne() {
        assertEquals(6, Solution().subsetXORSum(intArrayOf(1, 3)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(28, Solution().subsetXORSum(intArrayOf(5, 1, 6)))
    }

    @Test
    fun singleton() {
        assertEquals(7, Solution().subsetXORSum(intArrayOf(7)))
    }

    @Test
    fun emptyAndZeroInputs() {
        assertEquals(0, Solution().subsetXORSum(intArrayOf()))
        assertEquals(0, Solution().subsetXORSum(intArrayOf(0, 0, 0)))
    }
}
