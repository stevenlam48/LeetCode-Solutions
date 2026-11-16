package numberofvalidwordsinasentence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfValidWordsInASentenceTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().countValidWords("cat and  dog"))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().countValidWords("!this  1-s b8d!"))
    }

    @Test
    fun example3() {
        assertEquals(5, Solution().countValidWords("alice and  bob are playing stone-game10"))
    }

    @Test
    fun example4() {
        assertEquals(6, Solution().countValidWords("he bought 2 pencils, 3 erasers, and 1 pencil-sharpener."))
    }

    @Test
    fun singleWord() {
        assertEquals(1, Solution().countValidWords("a"))
    }

    @Test
    fun empty() {
        assertEquals(0, Solution().countValidWords(""))
    }
}
