package shortestdistancetoacharacter

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestDistanceToACharacterTest {
    @Test
    fun findsNearestOccurrenceOnEitherSide() {
        assertArrayEquals(
            intArrayOf(3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0),
            Solution().shortestToChar("loveleetcode", 'e')
        )
    }

    @Test
    fun handlesTargetAtEnd() {
        assertArrayEquals(intArrayOf(3, 2, 1, 0), Solution().shortestToChar("aaab", 'b'))
    }

    @Test
    fun handlesSingleCharacter() {
        assertArrayEquals(intArrayOf(0), Solution().shortestToChar("a", 'a'))
    }

    @Test
    fun handlesEveryOtherCharacter() {
        assertArrayEquals(intArrayOf(0, 1, 0, 1, 0), Solution().shortestToChar("ababa", 'a'))
    }
}
