package maximumnumberofcoinsyoucanget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfCoinsYouCanGetTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(9, solution.maxCoins(intArrayOf(2, 4, 1, 2, 7, 8)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(4, solution.maxCoins(intArrayOf(2, 4, 5)))
    }

    @Test
    fun exampleThree() {
        assertEquals(18, solution.maxCoins(intArrayOf(9, 8, 7, 6, 5, 1, 2, 3, 4)))
    }

    @Test
    fun singleTriple() {
        assertEquals(1, solution.maxCoins(intArrayOf(1, 1, 1)))
    }

    @Test
    fun duplicates() {
        assertEquals(8, solution.maxCoins(intArrayOf(4, 4, 4, 4, 4, 4)))
    }
}
