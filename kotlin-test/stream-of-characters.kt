package streamofcharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StreamOfCharactersTest {
    @Test
    fun `standard query stream`() {
        val checker = StreamChecker(listOf("cd", "f", "kl"))
        val actual = "aaabcdeffgijkl".map { checker.query(it) }
        val expected = listOf(false, false, false, false, false, true, false, true, true, false, false, false, false, true)
        assertEquals(expected, actual)
    }

    @Test
    fun `suffix matches shorter word`() {
        val checker = StreamChecker(listOf("a", "ba"))
        assertEquals(listOf(true, false, true), "aba".map { checker.query(it) })
    }

    @Test
    fun `failed match resumes at root`() {
        val checker = StreamChecker(listOf("abc"))
        assertEquals(listOf(false, false, false, true), "xabc".map { checker.query(it) })
    }
}
