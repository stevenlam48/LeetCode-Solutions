package minimumnumberofflipstoreversebinarystring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfFlipsToReverseBinaryStringTest {
    private val solution = Solution()

    @Test
    fun allOnesNeedsNoFlips() {
        assertEquals(0, solution.minimumFlips(7))
    }

    @Test
    fun alternatingBitsNeedFourFlips() {
        assertEquals(4, solution.minimumFlips(10))
    }

    @Test
    fun twoMismatchedBitsNeedTwoFlips() {
        assertEquals(2, solution.minimumFlips(6))
    }

    @Test
    fun singleBitNeedsNoFlips() {
        assertEquals(0, solution.minimumFlips(1))
    }
}
