package countvalidprefixes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountValidPrefixesTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().countValidPrefixes("00101"))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().countValidPrefixes("101"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().countValidPrefixes("1"))
        assertEquals(1, Solution().countValidPrefixes("0"))
    }

    @Test
    fun equalPairIsNotValid() {
        assertEquals(1, Solution().countValidPrefixes("00"))
    }

    @Test
    fun allSameCharacter() {
        assertEquals(1, Solution().countValidPrefixes("1111"))
    }

    @Test
    fun alternatingString() {
        assertEquals(4, Solution().countValidPrefixes("0101"))
    }
}
