package maximumcontainersonaship

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumContainersOnAShipTest {
    private val solution = Solution()

    @Test
    fun weightLimitsContainers() {
        assertEquals(7, solution.maxContainers(3, 2, 15))
    }

    @Test
    fun deckCapacityLimitsContainers() {
        assertEquals(16, solution.maxContainers(4, 3, 100))
    }

    @Test
    fun exactDeckAndWeightCapacity() {
        assertEquals(25, solution.maxContainers(5, 2, 50))
    }

    @Test
    fun noWeightCapacity() {
        assertEquals(0, solution.maxContainers(5, 2, 1))
    }
}
