package distributecandiesamongchildreniii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DistributeCandiesAmongChildrenIiiTest {
    private val solution = Solution()

    @Test
    fun boundedDistribution() {
        assertEquals(3L, solution.distributeCandies(5, 2))
    }

    @Test
    fun limitDoesNotBind() {
        assertEquals(10L, solution.distributeCandies(3, 3))
    }

    @Test
    fun onlyAllAtLimitWorks() {
        assertEquals(1L, solution.distributeCandies(3, 1))
    }

    @Test
    fun impossibleDistribution() {
        assertEquals(0L, solution.distributeCandies(10, 2))
    }
}
