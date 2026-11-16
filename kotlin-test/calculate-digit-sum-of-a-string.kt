package calculatedigitsumofastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculateDigitSumOfAStringTest {
    @Test
    fun leetCodeExample() {
        assertEquals("135", Solution().digitSum("11111222223", 3))
    }

    @Test
    fun zeroGroupsRemainPadded() {
        assertEquals("000", Solution().digitSum("00000000", 3))
    }

    @Test
    fun oneReductionRound() {
        assertEquals("37", Solution().digitSum("1234", 2))
    }

    @Test
    fun alreadyShortEnough() {
        assertEquals("987", Solution().digitSum("987", 3))
    }
}
