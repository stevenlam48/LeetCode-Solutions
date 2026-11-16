package increasingsubsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IncreasingSubsequencesTest {
    private fun asSet(lists: List<List<Int>>): Set<List<Int>> = lists.map { it.toList() }.toSet()

    @Test
    fun example1() {
        val expected = setOf(
            listOf(4, 6),
            listOf(4, 6, 7),
            listOf(4, 6, 7, 7),
            listOf(4, 7),
            listOf(4, 7, 7),
            listOf(6, 7),
            listOf(6, 7, 7),
            listOf(7, 7)
        )
        assertEquals(expected, asSet(Solution().findSubsequences(intArrayOf(4, 6, 7, 7))))
    }

    @Test
    fun example2() {
        assertEquals(setOf(listOf(4, 4)), asSet(Solution().findSubsequences(intArrayOf(4, 4, 3, 2, 1))))
    }

    @Test
    fun strictlyIncreasing() {
        val expected = setOf(
            listOf(1, 2),
            listOf(1, 2, 3),
            listOf(1, 3),
            listOf(2, 3)
        )
        assertEquals(expected, asSet(Solution().findSubsequences(intArrayOf(1, 2, 3))))
    }

    @Test
    fun duplicates() {
        assertEquals(
            setOf(listOf(1, 1), listOf(1, 1, 1)),
            asSet(Solution().findSubsequences(intArrayOf(1, 1, 1)))
        )
    }

    @Test
    fun tooShort() {
        assertEquals(emptySet<List<Int>>(), asSet(Solution().findSubsequences(intArrayOf(1))))
        assertEquals(emptySet<List<Int>>(), asSet(Solution().findSubsequences(intArrayOf(2, 1))))
    }
}
