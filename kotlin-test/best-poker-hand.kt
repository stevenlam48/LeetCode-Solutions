package bestpokerhand

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestPokerHandTest {
    private val solution = Solution()

    @Test
    fun flush() {
        assertEquals(
            "Flush",
            solution.bestHand(intArrayOf(13, 2, 3, 1, 10), charArrayOf('a', 'a', 'a', 'a', 'a'))
        )
    }

    @Test
    fun pair() {
        assertEquals(
            "Pair",
            solution.bestHand(intArrayOf(4, 4, 2, 3, 5), charArrayOf('a', 'd', 'a', 'b', 'a'))
        )
    }

    @Test
    fun threeOfAKind() {
        assertEquals(
            "Three of a Kind",
            solution.bestHand(intArrayOf(4, 4, 4, 2, 3), charArrayOf('a', 'd', 'a', 'b', 'a'))
        )
    }

    @Test
    fun highCard() {
        assertEquals(
            "High Card",
            solution.bestHand(intArrayOf(10, 5, 4, 7, 9), charArrayOf('a', 'b', 'c', 'd', 'a'))
        )
    }

    @Test
    fun flushTakesPrecedenceOverRanks() {
        assertEquals(
            "Flush",
            solution.bestHand(intArrayOf(4, 4, 4, 4, 4), charArrayOf('c', 'c', 'c', 'c', 'c'))
        )
    }
}
