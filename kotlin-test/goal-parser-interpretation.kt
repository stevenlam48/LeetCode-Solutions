package goalparserinterpretation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GoalParserInterpretationTest {
    @Test
    fun `standard examples`() {
        val solution = Solution()
        assertEquals("Goal", solution.interpret("G()(al)"))
        assertEquals("Gooooal", solution.interpret("G()()()()(al)"))
        assertEquals("alGalooG", solution.interpret("(al)G(al)()()G"))
    }

    @Test
    fun `only g tokens`() {
        assertEquals("GGG", Solution().interpret("GGG"))
    }

    @Test
    fun `alternating pair forms`() {
        assertEquals("oalo", Solution().interpret("()(al)()"))
    }
}
