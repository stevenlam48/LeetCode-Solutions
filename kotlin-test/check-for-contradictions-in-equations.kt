package checkforcontradictionsinequations

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckForContradictionsInEquationsTest {
    private val solution = Solution()

    @Test
    fun consistentIndirectEquations() {
        assertFalse(
            solution.checkContradictions(
                listOf(listOf("a", "b"), listOf("b", "c"), listOf("a", "c")),
                doubleArrayOf(2.0, 3.0, 6.0)
            )
        )
    }

    @Test
    fun contradictoryIndirectEquation() {
        assertTrue(
            solution.checkContradictions(
                listOf(listOf("a", "b"), listOf("b", "c"), listOf("a", "c")),
                doubleArrayOf(2.0, 3.0, 7.0)
            )
        )
    }

    @Test
    fun contradictoryDuplicateEquation() {
        assertTrue(
            solution.checkContradictions(
                listOf(listOf("a", "b"), listOf("a", "b")),
                doubleArrayOf(2.0, 1.0)
            )
        )
    }

    @Test
    fun disconnectedComponentsRemainConsistent() {
        assertFalse(
            solution.checkContradictions(
                listOf(listOf("a", "b"), listOf("c", "d")),
                doubleArrayOf(2.0, 8.0)
            )
        )
    }

    @Test
    fun noEquations() {
        assertFalse(solution.checkContradictions(emptyList(), doubleArrayOf()))
    }
}
