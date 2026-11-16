package simplifiedfractions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SimplifiedFractionsTest {
    private val solution = Solution()

    @Test
    fun `n equals two`() {
        assertEquals(listOf("1/2"), solution.simplifiedFractions(2))
    }

    @Test
    fun `n equals three`() {
        assertEquals(setOf("1/2", "1/3", "2/3"), solution.simplifiedFractions(3).toSet())
    }

    @Test
    fun `n equals four removes reducible fractions`() {
        val result = solution.simplifiedFractions(4)
        assertEquals(setOf("1/2", "1/3", "2/3", "1/4", "3/4"), result.toSet())
        assertEquals(5, result.size)
    }

    @Test
    fun `n below two has no fractions`() {
        assertTrue(solution.simplifiedFractions(1).isEmpty())
        assertTrue(solution.simplifiedFractions(0).isEmpty())
    }
}
