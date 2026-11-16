package numberofburgerswithnowasteofingredients

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberOfBurgersWithNoWasteOfIngredientsTest {
    private val solution = Solution()

    @Test
    fun `uses one jumbo and six small burgers`() {
        assertArrayEquals(intArrayOf(1, 6), solution.numOfBurgers(16, 7))
    }

    @Test
    fun `rejects tomato counts that cannot be distributed`() {
        assertArrayEquals(intArrayOf(), solution.numOfBurgers(17, 4))
        assertArrayEquals(intArrayOf(), solution.numOfBurgers(4, 17))
    }

    @Test
    fun `allows only small burgers`() {
        assertArrayEquals(intArrayOf(0, 2), solution.numOfBurgers(4, 2))
    }

    @Test
    fun `allows only jumbo burgers`() {
        assertArrayEquals(intArrayOf(2, 0), solution.numOfBurgers(8, 2))
    }

    @Test
    fun `allows zero burgers`() {
        assertArrayEquals(intArrayOf(0, 0), solution.numOfBurgers(0, 0))
    }
}
