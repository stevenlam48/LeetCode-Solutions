package minimumnumberofcoinstobeadded

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfCoinsToBeAddedTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(2, solution.minimumAddedCoins(intArrayOf(1, 4, 10), 19))
    }

    @Test
    fun secondExample() {
        assertEquals(1, solution.minimumAddedCoins(intArrayOf(1, 4, 10, 5, 7, 19), 19))
    }

    @Test
    fun thirdExample() {
        assertEquals(3, solution.minimumAddedCoins(intArrayOf(1, 1, 1), 20))
    }

    @Test
    fun emptyCoins() {
        assertEquals(1, solution.minimumAddedCoins(intArrayOf(), 1))
    }

    @Test
    fun targetAlreadyReachableWithUnsortedCoins() {
        assertEquals(0, solution.minimumAddedCoins(intArrayOf(3, 1, 2), 6))
    }
}
