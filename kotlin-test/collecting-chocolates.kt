package collectingchocolates

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CollectingChocolatesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(13L, solution.minCost(intArrayOf(20, 1, 15), 5))
    }

    @Test
    fun testExample2() {
        assertEquals(6L, solution.minCost(intArrayOf(1, 2, 3), 4))
    }

    @Test
    fun testSingleChocolate() {
        assertEquals(1L, solution.minCost(intArrayOf(1), 1))
    }

    @Test
    fun testAllEqual() {
        assertEquals(15L, solution.minCost(intArrayOf(5, 5, 5), 3))
    }

    @Test
    fun testNoRotationBeneficial() {
        assertEquals(2L, solution.minCost(intArrayOf(1, 1), 100))
    }
}
