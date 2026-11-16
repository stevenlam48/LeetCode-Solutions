package randompickindex

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RandomPickIndexTest {
    @Test
    fun testUniqueTarget() {
        val solution = Solution(intArrayOf(1, 2, 3))
        assertEquals(0, solution.pick(1))
        assertEquals(1, solution.pick(2))
        assertEquals(2, solution.pick(3))
    }

    @Test
    fun testDuplicateTargetCoversAllIndices() {
        val solution = Solution(intArrayOf(1, 2, 3, 3, 3))
        val seen = HashSet<Int>()
        repeat(2000) {
            val index = solution.pick(3)
            assertTrue(index in 2..4)
            seen.add(index)
        }
        assertEquals(setOf(2, 3, 4), seen)
    }

    @Test
    fun testSingleElement() {
        val solution = Solution(intArrayOf(5))
        repeat(10) {
            assertEquals(0, solution.pick(5))
        }
    }
}
