package kinversepairsarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KInversePairsArrayTest {
    @Test
    fun `only sorted permutation has zero inverse pairs`() {
        assertEquals(1, Solution().kInversePairs(3, 0))
    }

    @Test
    fun `three element permutations with one inverse pair`() {
        assertEquals(2, Solution().kInversePairs(3, 1))
    }

    @Test
    fun `three element permutations with two inverse pairs`() {
        assertEquals(2, Solution().kInversePairs(3, 2))
    }

    @Test
    fun `four element permutations with two inverse pairs`() {
        assertEquals(5, Solution().kInversePairs(4, 2))
    }

    @Test
    fun `too many inverse pairs is impossible`() {
        assertEquals(0, Solution().kInversePairs(3, 4))
    }
}
