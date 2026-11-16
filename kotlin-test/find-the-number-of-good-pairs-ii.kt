package findthenumberofgoodpairsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheNumberOfGoodPairsIITest {
    @Test
    fun example1() {
        assertEquals(
            2L,
            Solution().numberOfPairs(intArrayOf(1, 2, 4, 12), intArrayOf(2, 4), 3)
        )
    }

    @Test
    fun example2() {
        assertEquals(
            10L,
            Solution().numberOfPairs(
                intArrayOf(1, 2, 4, 8, 16, 32),
                intArrayOf(1, 2, 4, 8),
                4
            )
        )
    }

    @Test
    fun singlePair() {
        assertEquals(
            1L,
            Solution().numberOfPairs(intArrayOf(1), intArrayOf(1), 1)
        )
    }
}
