package remove9

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Remove9Test {
    @Test
    fun singleDigit() {
        assertEquals(1, Solution().newInteger(1))
    }

    @Test
    fun ninthInteger() {
        assertEquals(10, Solution().newInteger(9))
    }

    @Test
    fun tenthInteger() {
        assertEquals(11, Solution().newInteger(10))
    }

    @Test
    fun multipleBaseNineDigits() {
        assertEquals(121, Solution().newInteger(100))
        assertEquals(88, Solution().newInteger(80))
    }
}
