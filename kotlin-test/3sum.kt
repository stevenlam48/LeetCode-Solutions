package p3sum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class P3sumTest {
    private fun normalize(triples: Array<IntArray>): Set<List<Int>> =
        triples.map { it.toList() }.toSet()

    @Test
    fun example1() {
        val actual = Solution().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
        assertEquals(
            setOf(listOf(-1, -1, 2), listOf(-1, 0, 1)),
            normalize(actual)
        )
    }

    @Test
    fun example2() {
        assertEquals(emptySet<List<Int>>(), normalize(Solution().threeSum(intArrayOf(0, 1, 1))))
    }

    @Test
    fun example3() {
        assertEquals(setOf(listOf(0, 0, 0)), normalize(Solution().threeSum(intArrayOf(0, 0, 0))))
    }

    @Test
    fun empty() {
        assertEquals(emptySet<List<Int>>(), normalize(Solution().threeSum(intArrayOf())))
    }

    @Test
    fun allZeros() {
        assertEquals(setOf(listOf(0, 0, 0)), normalize(Solution().threeSum(intArrayOf(0, 0, 0, 0))))
    }

    @Test
    fun negatives() {
        val actual = Solution().threeSum(intArrayOf(-2, 0, 1, 1, 2))
        assertEquals(
            setOf(listOf(-2, 0, 2), listOf(-2, 1, 1)),
            normalize(actual)
        )
    }
}
