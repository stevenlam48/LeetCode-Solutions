package smallestsubstringwithidenticalcharactersi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestSubstringWithIdenticalCharactersITest {
    @Test
    fun example1() {
        assertEquals(2, Solution().minLength("000001", 1))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().minLength("0000", 2))
    }

    @Test
    fun alreadyAlternating() {
        assertEquals(1, Solution().minLength("0101", 0))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().minLength("1", 0))
    }

    @Test
    fun twoRunsOfThree() {
        assertEquals(3, Solution().minLength("000111", 1))
    }
}
