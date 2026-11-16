package minDistance

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinDistanceTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().minDistance("horse", "ros"))
    }

    @Test
    fun example2() {
        assertEquals(5, Solution().minDistance("intention", "execution"))
    }

    @Test
    fun emptyFirstWord() {
        assertEquals(3, Solution().minDistance("", "abc"))
    }

    @Test
    fun emptySecondWord() {
        assertEquals(3, Solution().minDistance("abc", ""))
    }

    @Test
    fun identicalWords() {
        assertEquals(0, Solution().minDistance("abc", "abc"))
    }
}
