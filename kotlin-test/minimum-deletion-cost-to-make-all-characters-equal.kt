package minimumdeletioncosttomakeallcharactersequal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDeletionCostToMakeAllCharactersEqualTest {
    @Test
    fun example1() {
        assertEquals(7L, Solution().minCost("abaac", intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun allDistinct() {
        assertEquals(3L, Solution().minCost("abc", intArrayOf(1, 2, 3)))
    }

    @Test
    fun single() {
        assertEquals(0L, Solution().minCost("a", intArrayOf(5)))
    }

    @Test
    fun allSame() {
        assertEquals(0L, Solution().minCost("aa", intArrayOf(1, 2)))
    }

    @Test
    fun twoChars() {
        assertEquals(1L, Solution().minCost("ab", intArrayOf(10, 1)))
    }
}
