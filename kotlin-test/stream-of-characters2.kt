package streamofcharacters2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StreamOfCharacters2Test {
    @Test
    fun `standard query stream`() {
        val checker = StreamChecker(listOf("cd", "f", "kl"))
        val actual = "aaabcdeffgijkl".map { checker.query(it) }
        assertEquals(
            listOf(false, false, false, false, false, true, false, true, true, false, false, false, false, true),
            actual
        )
    }

    @Test
    fun `suffix matches shorter word`() {
        val checker = StreamChecker(listOf("a", "ba"))
        assertEquals(listOf(true, false, true), "aba".map { checker.query(it) })
    }

    @Test
    fun `repeated word still matches`() {
        val checker = StreamChecker(listOf("a", "a"))
        assertEquals(listOf(true, true), "aa".map { checker.query(it) })
    }
}
