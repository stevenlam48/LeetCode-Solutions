package thewordinggame

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TheWordingGameTest {
    private val solution = Solution()

    @Test
    fun bobCanPlayLast() {
        assertFalse(solution.canAliceWin(listOf("apple"), listOf("avocado")))
    }

    @Test
    fun bobCanRespondWithAdjacentInitialLetter() {
        assertFalse(solution.canAliceWin(listOf("apple"), listOf("banana")))
    }

    @Test
    fun sameInitialLetterRequiresLargerWord() {
        assertTrue(solution.canAliceWin(listOf("apple"), listOf("aardvark")))
    }

    @Test
    fun lastSameLetterWordIsUsed() {
        assertTrue(solution.canAliceWin(listOf("apple", "cat"), listOf("bear", "beast")))
    }

    @Test
    fun largerInitialLetterGapPreventsPlay() {
        assertTrue(solution.canAliceWin(listOf("cat"), listOf("elephant")))
    }
}
