package minimumcostsusingthetrainline

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumCostsUsingTheTrainLineTest {
    @Test
    fun example1() {
        assertArrayEquals(
            longArrayOf(1, 7, 14, 19),
            Solution().minimumCosts(intArrayOf(1, 6, 9, 5), intArrayOf(5, 2, 3, 10), 8)
        )
    }

    @Test
    fun singleRegular() {
        assertArrayEquals(longArrayOf(1), Solution().minimumCosts(intArrayOf(1), intArrayOf(1), 1))
    }

    @Test
    fun singleExpress() {
        assertArrayEquals(longArrayOf(2), Solution().minimumCosts(intArrayOf(10), intArrayOf(1), 1))
    }

    @Test
    fun expressTooExpensive() {
        assertArrayEquals(
            longArrayOf(1, 2),
            Solution().minimumCosts(intArrayOf(1, 1), intArrayOf(100, 100), 100)
        )
    }

    @Test
    fun expressCheap() {
        assertArrayEquals(
            longArrayOf(2, 3),
            Solution().minimumCosts(intArrayOf(100, 100), intArrayOf(1, 1), 1)
        )
    }
}
