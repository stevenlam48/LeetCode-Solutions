package p4sum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class P4sumTest {
    private fun normalize(quads: Array<IntArray>): Set<List<Int>> =
        quads.map { it.toList() }.toSet()

    @Test
    fun example1() {
        val actual = Solution().fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0)
        assertEquals(
            setOf(
                listOf(-2, -1, 1, 2),
                listOf(-2, 0, 0, 2),
                listOf(-1, 0, 0, 1)
            ),
            normalize(actual)
        )
    }

    @Test
    fun example2() {
        assertEquals(setOf(listOf(2, 2, 2, 2)), normalize(Solution().fourSum(intArrayOf(2, 2, 2, 2, 2), 8)))
    }

    @Test
    fun tooShort() {
        assertEquals(emptySet<List<Int>>(), normalize(Solution().fourSum(intArrayOf(1, 2, 3), 6)))
    }

    @Test
    fun noSolution() {
        assertEquals(emptySet<List<Int>>(), normalize(Solution().fourSum(intArrayOf(1, 2, 3, 4), 100)))
    }

    @Test
    fun negatives() {
        val actual = Solution().fourSum(intArrayOf(-3, -1, 0, 2, 4, 5), 2)
        assertEquals(setOf(listOf(-3, -1, 2, 4)), normalize(actual))
    }
}
