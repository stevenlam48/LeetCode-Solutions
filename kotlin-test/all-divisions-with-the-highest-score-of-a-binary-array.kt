package alldivisionswiththehighestscoreofabinaryarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AllDivisionsWithTheHighestScoreOfABinaryArrayTest {
    @Test
    fun testExample1() {
        assertEquals(listOf(2, 4), Solution().maxScoreIndices(intArrayOf(0, 0, 1, 0)))
    }

    @Test
    fun testExample2() {
        assertEquals(listOf(0), Solution().maxScoreIndices(intArrayOf(1, 1)))
    }

    @Test
    fun testAllZeros() {
        assertEquals(listOf(3), Solution().maxScoreIndices(intArrayOf(0, 0, 0)))
    }

    @Test
    fun testMixed() {
        assertEquals(listOf(0, 2), Solution().maxScoreIndices(intArrayOf(1, 0, 1)))
    }
}
