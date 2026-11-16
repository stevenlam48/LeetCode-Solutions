package tuplewithsameproduct

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TupleWithSameProductTest {
    @Test
    fun standardExamples() {
        assertEquals(8, Solution().tupleSameProduct(intArrayOf(2, 3, 4, 6)))
        assertEquals(16, Solution().tupleSameProduct(intArrayOf(1, 2, 4, 5, 10)))
    }

    @Test
    fun multipleMatchingPairs() {
        assertEquals(40, Solution().tupleSameProduct(intArrayOf(2, 3, 4, 6, 1, 12)))
    }

    @Test
    fun tooFewPairsOrNoMatches() {
        assertEquals(0, Solution().tupleSameProduct(intArrayOf(1, 2, 3)))
        assertEquals(0, Solution().tupleSameProduct(intArrayOf(2, 4, 8)))
    }
}
