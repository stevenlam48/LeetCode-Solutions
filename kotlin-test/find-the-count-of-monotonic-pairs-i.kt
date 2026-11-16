package findthecountofmonotonicpairsi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheCountOfMonotonicPairsITest {
    @Test
    fun countsMixedArray() {
        assertEquals(4, Solution().countOfPairs(intArrayOf(2, 3, 2)))
    }

    @Test
    fun countsUniformArray() {
        assertEquals(126, Solution().countOfPairs(intArrayOf(5, 5, 5, 5)))
    }

    @Test
    fun returnsZeroWhenNoPairsExist() {
        assertEquals(0, Solution().countOfPairs(intArrayOf(1, 3, 1)))
    }

    @Test
    fun handlesSingleElement() {
        assertEquals(1, Solution().countOfPairs(intArrayOf(0)))
    }
}
