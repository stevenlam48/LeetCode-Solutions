package houserobberii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HouseRobberIiTest {
    @Test
    fun firstAndLastAreAdjacent() {
        assertEquals(3, Solution().rob(intArrayOf(2, 3, 2)))
    }

    @Test
    fun standardExample() {
        assertEquals(4, Solution().rob(intArrayOf(1, 2, 3, 1)))
    }

    @Test
    fun threeHouses() {
        assertEquals(3, Solution().rob(intArrayOf(1, 2, 3)))
    }

    @Test
    fun emptyAndSingleHouse() {
        assertEquals(0, Solution().rob(intArrayOf()))
        assertEquals(7, Solution().rob(intArrayOf(7)))
    }

    @Test
    fun bestChoiceUsesTwoOppositeHouses() {
        assertEquals(8, Solution().rob(intArrayOf(4, 4, 4, 4)))
    }
}
