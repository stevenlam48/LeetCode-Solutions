package findthecountofmonotonicpairsii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheCountOfMonotonicPairsIITest {
    @Test
    fun countsMixedArray() {
        assertEquals(4, Solution().countOfPairs(intArrayOf(2, 3, 2)))
    }

    @Test
    fun countsUniformArray() {
        assertEquals(126, Solution().countOfPairs(intArrayOf(5, 5, 5, 5)))
    }

    @Test
    fun handlesLargeValuesWithModularArithmetic() {
        assertEquals(501501, Solution().countOfPairs(intArrayOf(1000, 1000)))
    }

    @Test
    fun returnsZeroWhenNoPairsExist() {
        assertEquals(0, Solution().countOfPairs(intArrayOf(1, 3, 1)))
    }
}
