package countwaystobuildgoodstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountWaysToBuildGoodStringsTest {
    @Test
    fun example1() {
        assertEquals(8, Solution().countGoodStrings(3, 3, 1, 1))
    }

    @Test
    fun example2() {
        assertEquals(5, Solution().countGoodStrings(2, 3, 1, 2))
    }

    @Test
    fun singleLength() {
        assertEquals(2, Solution().countGoodStrings(1, 1, 1, 1))
    }

    @Test
    fun zeroAndOneEqualLow() {
        assertEquals(2, Solution().countGoodStrings(2, 2, 2, 2))
    }
}
