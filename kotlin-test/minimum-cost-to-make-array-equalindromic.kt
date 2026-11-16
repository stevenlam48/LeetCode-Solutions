package minimumcosttomakearrayequalindromic

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToMakeArrayEqualindromicTest {
    private val solution = Solution()

    @Test
    fun firstLeetCodeExample() {
        assertEquals(6L, solution.minimumCost(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun secondLeetCodeExample() {
        assertEquals(11L, solution.minimumCost(intArrayOf(10, 12, 13, 14, 15)))
    }

    @Test
    fun thirdLeetCodeExample() {
        assertEquals(22L, solution.minimumCost(intArrayOf(22, 33, 22, 33, 22)))
    }

    @Test
    fun alreadyPalindromicSingleElement() {
        assertEquals(0L, solution.minimumCost(intArrayOf(9)))
    }
}
