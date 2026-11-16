package distributecandies

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DistributeCandiesTest {
    private val solution = Solution()

    @Test
    fun enoughTypesForHalf() {
        assertEquals(3, solution.distributeCandies(intArrayOf(1, 1, 2, 2, 3, 3)))
    }

    @Test
    fun moreTypesThanAllowed() {
        assertEquals(2, solution.distributeCandies(intArrayOf(1, 1, 2, 3)))
    }

    @Test
    fun onlyOneType() {
        assertEquals(1, solution.distributeCandies(intArrayOf(6, 6, 6, 6)))
    }
}
