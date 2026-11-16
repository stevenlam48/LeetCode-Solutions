package specialbinarystring

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SpecialBinaryStringTest {
    @Test
    fun exampleOne() {
        assertEquals("11100100", Solution().makeLargestSpecial("11011000"))
    }

    @Test
    fun minimalSpecialString() {
        assertEquals("10", Solution().makeLargestSpecial("10"))
    }

    @Test
    fun concatenationOfTwoMinimalStrings() {
        assertEquals("1010", Solution().makeLargestSpecial("1010"))
    }

    @Test
    fun nestedSpecialString() {
        assertEquals("1100", Solution().makeLargestSpecial("1100"))
        assertEquals("111000", Solution().makeLargestSpecial("111000"))
    }
}
