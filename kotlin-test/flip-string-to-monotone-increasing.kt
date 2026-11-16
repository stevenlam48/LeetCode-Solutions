package flipstringtomonotoneincreasing

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FlipStringToMonotoneIncreasingTest {
    @Test
    fun standardExamples() {
        assertEquals(1, Solution().minFlipsMonoIncr("00110"))
        assertEquals(2, Solution().minFlipsMonoIncr("010110"))
        assertEquals(2, Solution().minFlipsMonoIncr("00011000"))
    }

    @Test
    fun alreadyMonotoneStrings() {
        assertEquals(0, Solution().minFlipsMonoIncr("00000"))
        assertEquals(0, Solution().minFlipsMonoIncr("11111"))
        assertEquals(0, Solution().minFlipsMonoIncr("001111"))
    }

    @Test
    fun singleCharacterStrings() {
        assertEquals(0, Solution().minFlipsMonoIncr("0"))
        assertEquals(0, Solution().minFlipsMonoIncr("1"))
    }

    @Test
    fun alternatingCharacters() {
        assertEquals(2, Solution().minFlipsMonoIncr("1010"))
        assertEquals(1, Solution().minFlipsMonoIncr("10"))
    }
}
