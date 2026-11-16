package minimumdeletioncosttoavoidrepeatingletters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDeletionCostToAvoidRepeatingLettersTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().minCost("abaac", intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun noRepeats() {
        assertEquals(0, Solution().minCost("abc", intArrayOf(1, 2, 3)))
    }

    @Test
    fun twoGroups() {
        assertEquals(2, Solution().minCost("aabaa", intArrayOf(1, 2, 3, 4, 1)))
    }

    @Test
    fun allSame() {
        assertEquals(12, Solution().minCost("aaaa", intArrayOf(3, 4, 5, 6)))
    }

    @Test
    fun single() {
        assertEquals(0, Solution().minCost("a", intArrayOf(7)))
    }
}
