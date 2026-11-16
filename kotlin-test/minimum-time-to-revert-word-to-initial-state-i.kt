package minimumtimetorevertwordtoinitialstatei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeToRevertWordToInitialStateITest {
    @Test
    fun suffixMatchesAfterTwoOperations() {
        assertEquals(2, Solution().minimumTimeToInitialState("abacaba", 3))
    }

    @Test
    fun suffixMatchesAfterOneOperation() {
        assertEquals(1, Solution().minimumTimeToInitialState("abacaba", 4))
    }

    @Test
    fun noMatchingSuffix() {
        assertEquals(3, Solution().minimumTimeToInitialState("abcdef", 2))
    }

    @Test
    fun repeatedCharacters() {
        assertEquals(1, Solution().minimumTimeToInitialState("aaaa", 2))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().minimumTimeToInitialState("z", 1))
    }
}
