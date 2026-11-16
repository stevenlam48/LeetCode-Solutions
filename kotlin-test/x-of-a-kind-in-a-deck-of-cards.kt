package xofakindinadeckofcards

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class XOfAKindInADeckOfCardsTest {
    @Test
    fun examples() {
        assertTrue(Solution().hasGroupsSizeX(intArrayOf(1, 2, 3, 4, 4, 3, 2, 1)))
        assertFalse(Solution().hasGroupsSizeX(intArrayOf(1, 1, 1, 2, 2, 2, 3, 3)))
    }

    @Test
    fun singleCard() {
        assertFalse(Solution().hasGroupsSizeX(intArrayOf(1)))
    }

    @Test
    fun emptyDeck() {
        assertFalse(Solution().hasGroupsSizeX(intArrayOf()))
    }

    @Test
    fun coprimeFrequencies() {
        assertFalse(Solution().hasGroupsSizeX(intArrayOf(1, 1, 2, 2, 2)))
        assertTrue(Solution().hasGroupsSizeX(intArrayOf(1, 1, 1, 1, 2, 2, 2, 2, 3, 3)))
    }
}
