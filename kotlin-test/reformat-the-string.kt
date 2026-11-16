package reformatthestring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReformatTheStringTest {
    @Test
    fun balancedLettersAndDigits() {
        assertEquals("a0b1c2", Solution().reformat("a0b1c2"))
    }

    @Test
    fun tooManyLetters() {
        assertEquals("", Solution().reformat("leetcode"))
    }

    @Test
    fun tooManyDigits() {
        assertEquals("", Solution().reformat("1229857369"))
    }

    @Test
    fun oneExtraLetter() {
        assertEquals("c0d1i2o9v", Solution().reformat("covid2019"))
    }

    @Test
    fun oneExtraDigit() {
        assertEquals("1a2b3", Solution().reformat("ab123"))
    }
}
