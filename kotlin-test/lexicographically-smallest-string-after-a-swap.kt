package lexicographicallysmalleststringafteraswap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestStringAfterASwapTest {
    private val solution = Solution()

    @Test
    fun swapsFirstBeneficialSameParityPair() {
        assertEquals("43520", solution.getSmallestString("45320"))
    }

    @Test
    fun leavesStringWithoutValidDescendingPairUnchanged() {
        assertEquals("001", solution.getSmallestString("001"))
        assertEquals("13", solution.getSmallestString("13"))
    }

    @Test
    fun performsOnlyTheFirstSwap() {
        assertEquals("24350", solution.getSmallestString("42350"))
    }

    @Test
    fun allowsLeadingZeroAfterSwap() {
        assertEquals("02", solution.getSmallestString("20"))
    }

    @Test
    fun handlesSingleDigit() {
        assertEquals("9", solution.getSmallestString("9"))
    }
}
