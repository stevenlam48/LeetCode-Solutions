package findthenumberofgoodpairsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheNumberOfGoodPairsITest {
    @Test
    fun example1() {
        assertEquals(
            5,
            Solution().numberOfPairs(intArrayOf(1, 3, 4), intArrayOf(1, 3, 4), 1)
        )
    }

    @Test
    fun example2() {
        assertEquals(
            2,
            Solution().numberOfPairs(intArrayOf(1, 2, 4, 12), intArrayOf(2, 4), 3)
        )
    }

    @Test
    fun singlePair() {
        assertEquals(
            1,
            Solution().numberOfPairs(intArrayOf(1), intArrayOf(1), 1)
        )
    }
}
