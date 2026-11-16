package revealcardsinincreasingorder

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RevealCardsInIncreasingOrderTest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(2, 13, 3, 11, 5, 17, 7),
            Solution().deckRevealedIncreasing(intArrayOf(17, 13, 11, 2, 3, 5, 7))
        )
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(1, 1000),
            Solution().deckRevealedIncreasing(intArrayOf(1, 1000))
        )
    }

    @Test
    fun singleCard() {
        assertArrayEquals(
            intArrayOf(1),
            Solution().deckRevealedIncreasing(intArrayOf(1))
        )
    }

    @Test
    fun threeCards() {
        assertArrayEquals(
            intArrayOf(1, 3, 2),
            Solution().deckRevealedIncreasing(intArrayOf(1, 2, 3))
        )
    }

    @Test
    fun alreadyIncreasing() {
        assertArrayEquals(
            intArrayOf(1, 5, 2, 4, 3),
            Solution().deckRevealedIncreasing(intArrayOf(1, 2, 3, 4, 5))
        )
    }
}
