package applysubstitutions

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ApplySubstitutionsTest {
    private val solution = Solution()

    @Test
    fun independentSubstitutions() {
        assertEquals(
            "abc_def",
            solution.applySubstitutions(
                listOf(listOf("A", "abc"), listOf("B", "def")),
                "%A%_%B%"
            )
        )
    }

    @Test
    fun chainedSubstitutions() {
        assertEquals(
            "bceefgh",
            solution.applySubstitutions(
                listOf(listOf("A", "bce"), listOf("B", "%A%ef"), listOf("C", "%B%gh")),
                "%C%"
            )
        )
    }

    @Test
    fun dependencyOnMultipleKeys() {
        assertEquals(
            "abcabcxyz!",
            solution.applySubstitutions(
                listOf(listOf("A", "abc"), listOf("B", "%A%xyz"), listOf("C", "%A%%B%")),
                "%C%!"
            )
        )
    }

    @Test
    fun textWithoutPlaceholders() {
        assertEquals("plain text", solution.applySubstitutions(emptyList(), "plain text"))
    }
}
