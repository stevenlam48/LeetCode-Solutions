package waystoexpressanintegerassumofpowers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WaysToExpressAnIntegerAsSumOfPowersTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(1, solution.numberOfWays(10, 2))
    }

    @Test
    fun example2() {
        assertEquals(2, solution.numberOfWays(4, 1))
    }

    @Test
    fun firstPowerDistinctParts() {
        assertEquals(10, solution.numberOfWays(10, 1))
    }

    @Test
    fun smallInputs() {
        assertEquals(1, solution.numberOfWays(1, 1))
        assertEquals(1, solution.numberOfWays(2, 1))
        assertEquals(1, solution.numberOfWays(5, 2))
    }

    @Test
    fun fifthPowerLargeInput() {
        assertEquals(0, solution.numberOfWays(300, 5))
    }

    @Test
    fun firstPowerLargeInput() {
        assertEquals(872471266, solution.numberOfWays(300, 1))
    }
}
