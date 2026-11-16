package smallestsubstringwithidenticalcharactersii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestSubstringWithIdenticalCharactersIITest {
    @Test
    fun example1() {
        assertEquals(2, Solution().minLength("000001", 1))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().minLength("0000", 2))
    }

    @Test
    fun longRunWithOneOperation() {
        assertEquals(5, Solution().minLength("0000000000", 1))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().minLength("0", 0))
    }

    @Test
    fun noOperationsNeeded() {
        assertEquals(1, Solution().minLength("1010", 0))
    }
}
