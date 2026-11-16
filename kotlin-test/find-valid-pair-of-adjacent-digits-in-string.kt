package findvalidpairofadjacentdigitsinstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindValidPairOfAdjacentDigitsInStringTest {
    @Test
    fun exampleOne() {
        assertEquals("23", Solution().findValidPair("2523533"))
    }

    @Test
    fun exampleTwo() {
        assertEquals("21", Solution().findValidPair("221"))
    }

    @Test
    fun exampleThree() {
        assertEquals("", Solution().findValidPair("22"))
    }

    @Test
    fun repeatedDigitsAreNotAPair() {
        assertEquals("", Solution().findValidPair("11"))
    }
}
