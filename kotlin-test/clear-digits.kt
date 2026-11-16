package cleardigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClearDigitsTest {
    @Test
    fun noDigits() {
        assertEquals("abc", Solution().clearDigits("abc"))
    }

    @Test
    fun removesDigitAndClosestLeftLetter() {
        assertEquals("ab", Solution().clearDigits("abc3"))
    }

    @Test
    fun clearsAllLetters() {
        assertEquals("", Solution().clearDigits("cb34"))
    }

    @Test
    fun laterDigitsRemoveRemainingLetters() {
        assertEquals("b", Solution().clearDigits("a1bc2"))
    }
}
