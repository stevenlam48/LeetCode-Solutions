package minimumcostofbuyingcandieswithdiscount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostOfBuyingCandiesWithDiscountTest {
    @Test
    fun standardExamples() {
        assertEquals(5, Solution().minimumCost(intArrayOf(1, 2, 3)))
        assertEquals(23, Solution().minimumCost(intArrayOf(6, 5, 7, 9, 2, 2)))
    }

    @Test
    fun singleCandy() {
        assertEquals(1, Solution().minimumCost(intArrayOf(1)))
    }

    @Test
    fun fourEqualCandies() {
        assertEquals(30, Solution().minimumCost(intArrayOf(10, 10, 10, 10)))
    }

    @Test
    fun twoCandies() {
        assertEquals(3, Solution().minimumCost(intArrayOf(1, 2)))
    }
}
