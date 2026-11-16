package waterbottlesii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WaterBottlesIiTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(15, solution.maxBottlesDrunk(13, 6))
    }

    @Test
    fun example2() {
        assertEquals(13, solution.maxBottlesDrunk(10, 3))
    }

    @Test
    fun cannotExchange() {
        assertEquals(1, solution.maxBottlesDrunk(1, 2))
        assertEquals(2, solution.maxBottlesDrunk(2, 3))
    }

    @Test
    fun exchangeCostGrows() {
        assertEquals(7, solution.maxBottlesDrunk(5, 2))
    }
}
