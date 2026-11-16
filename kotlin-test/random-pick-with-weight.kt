package randompickwithweight

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RandomPickWithWeightTest {
    @Test
    fun testSingleWeight() {
        val solution = Solution(intArrayOf(1))
        repeat(20) {
            assertEquals(0, solution.pickIndex())
        }
    }

    @Test
    fun testAllIndicesReachable() {
        val solution = Solution(intArrayOf(1, 3))
        val counts = IntArray(2)
        repeat(20000) {
            val index = solution.pickIndex()
            assertTrue(index in 0..1)
            counts[index]++
        }
        assertTrue(counts[0] > 0)
        assertTrue(counts[1] > 0)
        assertTrue(counts[1] > counts[0])
    }

    @Test
    fun testThreeWeights() {
        val solution = Solution(intArrayOf(1, 1, 1))
        val seen = HashSet<Int>()
        repeat(2000) {
            val index = solution.pickIndex()
            assertTrue(index in 0..2)
            seen.add(index)
        }
        assertEquals(setOf(0, 1, 2), seen)
    }
}
