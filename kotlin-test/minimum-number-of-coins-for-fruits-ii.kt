package minimumnumberofcoinsforfruitsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfCoinsForFruitsIiTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(4, solution.minimumCoins(intArrayOf(3, 1, 2)))
    }

    @Test
    fun secondExample() {
        assertEquals(2, solution.minimumCoins(intArrayOf(1, 10, 1, 1)))
    }

    @Test
    fun singleFruit() {
        assertEquals(7, solution.minimumCoins(intArrayOf(7)))
    }

    @Test
    fun increasingPrices() {
        assertEquals(4, solution.minimumCoins(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun equalPrices() {
        assertEquals(4, solution.minimumCoins(intArrayOf(2, 2, 2, 2)))
    }
}
