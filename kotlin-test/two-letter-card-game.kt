package twolettercardgame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TwoLetterCardGameTest {
    @Test
    fun singleDouble() {
        assertEquals(1, Solution().score(listOf("aa", "ab"), 'a'))
    }

    @Test
    fun oneSharedWithThreePartners() {
        assertEquals(1, Solution().score(listOf("ab", "ac", "ad"), 'a'))
    }

    @Test
    fun oneOfEach() {
        assertEquals(1, Solution().score(listOf("ab", "ba", "aa"), 'a'))
    }

    @Test
    fun twoPairs() {
        assertEquals(2, Solution().score(listOf("ab", "ac", "ba", "ca", "aa"), 'a'))
    }

    @Test
    fun noCards() {
        assertEquals(0, Solution().score(listOf("bc", "de"), 'a'))
    }
}
