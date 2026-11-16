package minimumdeletionsforatmostkdistinctcharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDeletionsForAtMostKDistinctCharactersTest {
    @Test
    fun threeDistinctK2() {
        assertEquals(1, Solution().minDeletion("abc", 2))
    }

    @Test
    fun threePairsK2() {
        assertEquals(2, Solution().minDeletion("aabbcc", 2))
    }

    @Test
    fun fourTriplesK3() {
        assertEquals(3, Solution().minDeletion("aaabbbcccddd", 3))
    }

    @Test
    fun alreadyOk() {
        assertEquals(0, Solution().minDeletion("abc", 3))
    }

    @Test
    fun single() {
        assertEquals(0, Solution().minDeletion("a", 1))
    }

    @Test
    fun kZero() {
        assertEquals(4, Solution().minDeletion("aaaa", 0))
    }
}
