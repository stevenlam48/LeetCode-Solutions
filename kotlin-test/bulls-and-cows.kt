package bullsandcows

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BullsAndCowsTest {
    @Test
    fun leetCodeExample() {
        assertEquals("1A3B", Solution().getHint("1807", "7810"))
    }

    @Test
    fun duplicateDigits() {
        assertEquals("1A1B", Solution().getHint("1123", "0111"))
    }

    @Test
    fun duplicatesAreNotCountedTwice() {
        assertEquals("1A0B", Solution().getHint("11", "10"))
    }

    @Test
    fun allDigitsAreCows() {
        assertEquals("0A4B", Solution().getHint("1234", "4321"))
    }
}
