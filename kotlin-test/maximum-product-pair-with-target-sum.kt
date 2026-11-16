package maximumproductpairwithtargetsum

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumProductPairWithTargetSumTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(2, 1), Solution().maxProductPair(intArrayOf(1, 2, 3, 4, 5), 5))
    }

    @Test
    fun noPair() {
        assertArrayEquals(intArrayOf(-1, -1), Solution().maxProductPair(intArrayOf(1, 1, 2, 2), 4))
    }

    @Test
    fun laterPairWins() {
        assertArrayEquals(intArrayOf(3, 2), Solution().maxProductPair(intArrayOf(2, 5, 3, 4), 7))
    }

    @Test
    fun earlierPairWins() {
        assertArrayEquals(intArrayOf(1, 0), Solution().maxProductPair(intArrayOf(3, 4, 2, 5), 7))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(-1, -1), Solution().maxProductPair(intArrayOf(5), 10))
    }
}
