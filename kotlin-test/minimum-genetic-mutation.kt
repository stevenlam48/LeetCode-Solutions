package minimumgeneticmutation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumGeneticMutationTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().minMutation("AACCGGTT", "AACCGGTA", listOf("AACCGGTA")))
    }

    @Test
    fun example2() {
        val bank = listOf("AACCGGTA", "AACCGCTA", "AAACGGTA")
        assertEquals(2, Solution().minMutation("AACCGGTT", "AAACGGTA", bank))
    }

    @Test
    fun example3() {
        val bank = listOf("AAAACCCC", "AAACCCCC", "AACCCCCC")
        assertEquals(3, Solution().minMutation("AAAAACCC", "AACCCCCC", bank))
    }

    @Test
    fun startEqualsEnd() {
        assertEquals(0, Solution().minMutation("AACCGGTT", "AACCGGTT", listOf()))
    }

    @Test
    fun unreachableTarget() {
        assertEquals(-1, Solution().minMutation("AACCGGTT", "AACCGGTA", listOf()))
    }
}
