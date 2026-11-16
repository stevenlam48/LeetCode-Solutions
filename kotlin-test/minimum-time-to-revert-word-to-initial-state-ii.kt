package minimumtimetorevertwordtoinitialstateii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeToRevertWordToInitialStateIITest {
    @Test
    fun repeatedBlocks() {
        assertEquals(1, Solution().minimumTimeToInitialState("abcabcabc", 3))
    }

    @Test
    fun matchingSuffixAtLaterStep() {
        assertEquals(2, Solution().minimumTimeToInitialState("abacaba", 3))
    }

    @Test
    fun allCharactersRemoved() {
        assertEquals(4, Solution().minimumTimeToInitialState("abcdefgh", 2))
    }

    @Test
    fun uniformWord() {
        assertEquals(1, Solution().minimumTimeToInitialState("mmmm", 2))
    }

    @Test
    fun largestAllowedStep() {
        assertEquals(2, Solution().minimumTimeToInitialState("abcdefgh", 4))
    }
}
