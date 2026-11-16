package minimumnumberofflipstomakethebinarystringalternating

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfFlipsToMakeTheBinaryStringAlternatingTest {
    private val solution = Solution()

    @Test
    fun oneFlipWithoutRotation() {
        assertEquals(1, solution.minFlips("0100"))
    }

    @Test
    fun alreadyAlternating() {
        assertEquals(0, solution.minFlips("10"))
    }

    @Test
    fun twoFlips() {
        assertEquals(2, solution.minFlips("111000"))
    }

    @Test
    fun oddLengthRotationAvoidsFlips() {
        assertEquals(0, solution.minFlips("001"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(0, solution.minFlips("0"))
    }
}
