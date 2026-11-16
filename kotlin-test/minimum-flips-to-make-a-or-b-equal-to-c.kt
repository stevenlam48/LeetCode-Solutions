package minimumflipstomakeaorbequaltoc

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumFlipsToMakeAOrBEqualToCTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().minFlips(2, 6, 5))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().minFlips(4, 2, 7))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().minFlips(1, 2, 3))
    }

    @Test
    fun flipSingleBitInC() {
        assertEquals(1, Solution().minFlips(0, 0, 1))
    }

    @Test
    fun allZero() {
        assertEquals(0, Solution().minFlips(0, 0, 0))
    }
}
