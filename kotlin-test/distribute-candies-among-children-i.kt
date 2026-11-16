package distributecandiesamongchildreni

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DistributeCandiesAmongChildrenITest {
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
    fun impossibleDistribution() {
        assertEquals(0L, solution.distributeCandies(4, 1))
    }

    @Test
    fun oneCandy() {
        assertEquals(3L, solution.distributeCandies(1, 1))
    }
}
