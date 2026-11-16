package kitemswiththemaximumsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KItemsWithTheMaximumSumTest {
    @Test
    fun `takes all positive items first`() {
        assertEquals(2, Solution().kItemsWithMaximumSum(3, 2, 3, 2))
    }

    @Test
    fun `zeros preserve the sum`() {
        assertEquals(3, Solution().kItemsWithMaximumSum(3, 2, 3, 5))
    }

    @Test
    fun `negative items reduce the sum`() {
        assertEquals(2, Solution().kItemsWithMaximumSum(3, 2, 3, 6))
    }

    @Test
    fun `only negative items are available`() {
        assertEquals(-3, Solution().kItemsWithMaximumSum(0, 0, 4, 3))
    }

    @Test
    fun `taking no items gives zero`() {
        assertEquals(0, Solution().kItemsWithMaximumSum(3, 2, 3, 0))
    }
}
