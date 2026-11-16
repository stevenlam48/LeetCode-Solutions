package russiandollenvelopes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RussianDollEnvelopesTest {
    @Test
    fun leetCodeExample() {
        val envelopes = arrayOf(
            intArrayOf(5, 4),
            intArrayOf(6, 4),
            intArrayOf(6, 7),
            intArrayOf(2, 3)
        )
        assertEquals(3, Solution().maxEnvelopes(envelopes))
    }

    @Test
    fun identicalEnvelopesDoNotNest() {
        val envelopes = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        assertEquals(1, Solution().maxEnvelopes(envelopes))
    }

    @Test
    fun strictlyIncreasingChain() {
        val envelopes = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5)
        )
        assertEquals(4, Solution().maxEnvelopes(envelopes))
    }

    @Test
    fun sameWidthOnlyOneMayNest() {
        val envelopes = arrayOf(
            intArrayOf(4, 5),
            intArrayOf(4, 6),
            intArrayOf(6, 7),
            intArrayOf(2, 3),
            intArrayOf(1, 1)
        )
        assertEquals(4, Solution().maxEnvelopes(envelopes))
    }

    @Test
    fun singleEnvelope() {
        val envelopes = arrayOf(intArrayOf(2, 2))
        assertEquals(1, Solution().maxEnvelopes(envelopes))
    }

    @Test
    fun descendingOrder() {
        val envelopes = arrayOf(
            intArrayOf(3, 3),
            intArrayOf(2, 2),
            intArrayOf(1, 1)
        )
        assertEquals(3, Solution().maxEnvelopes(envelopes))
    }
}
