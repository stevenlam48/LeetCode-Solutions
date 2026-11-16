package splitstringsbyseparator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SplitStringsBySeparatorTest {
    private val solution = Solution()

    @Test
    fun `splits each word and preserves word order`() {
        assertEquals(
            listOf("one", "two", "three", "four", "five", "six"),
            solution.splitWordsBySeparator(listOf("one.two.three", "four.five", "six"), '.')
        )
    }

    @Test
    fun `discards leading and trailing empty strings`() {
        assertEquals(
            listOf("easy", "problem"),
            solution.splitWordsBySeparator(listOf("${'$'}easy${'$'}", "${'$'}problem${'$'}"), '$')
        )
    }

    @Test
    fun `returns an empty result for separators only`() {
        assertEquals(emptyList<String>(), solution.splitWordsBySeparator(listOf("|||"), '|'))
    }

    @Test
    fun `ignores empty words and consecutive separators`() {
        assertEquals(
            listOf("a", "b", "c"),
            solution.splitWordsBySeparator(listOf("", ".a..b.", "c"), '.')
        )
    }

    @Test
    fun `returns an empty result for no words`() {
        assertEquals(emptyList<String>(), solution.splitWordsBySeparator(emptyList(), ','))
    }
}
