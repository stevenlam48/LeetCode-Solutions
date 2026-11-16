package minimumnumberofswapstomakethebinarystringalternating

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfSwapsToMakeTheBinaryStringAlternatingTest {
    private val solution = Solution()

    @Test
    fun swapsToStartWithZero() {
        assertEquals(1, solution.minSwaps("111000"))
    }

    @Test
    fun alreadyAlternating() {
        assertEquals(0, solution.minSwaps("010"))
    }

    @Test
    fun impossibleCharacterCounts() {
        assertEquals(-1, solution.minSwaps("1110"))
    }

    @Test
    fun equalCountsChooseMinimum() {
        assertEquals(1, solution.minSwaps("0011"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(0, solution.minSwaps("1"))
        assertEquals(0, solution.minSwaps("0"))
    }
}
