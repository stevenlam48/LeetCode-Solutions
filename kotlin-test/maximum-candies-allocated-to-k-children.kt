package maximumcandiesallocatedtokchildren

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumCandiesAllocatedToKChildrenTest {
    @Test
    fun example() {
        assertEquals(5, Solution().maximumCandies(intArrayOf(5, 8, 6), 3L))
    }

    @Test
    fun notEnoughCandies() {
        assertEquals(0, Solution().maximumCandies(intArrayOf(2, 5), 11L))
    }

    @Test
    fun singleCandySingleChild() {
        assertEquals(1, Solution().maximumCandies(intArrayOf(1), 1L))
    }

    @Test
    fun twoPilesTwoChildren() {
        assertEquals(4, Solution().maximumCandies(intArrayOf(4, 7), 2L))
    }
}
