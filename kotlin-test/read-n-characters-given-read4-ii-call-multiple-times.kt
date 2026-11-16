package readncharactersgivenread4iicallmultipletimes
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ReadNCharactersGivenRead4IiCallMultipleTimesTest {
    private fun reader(source: String): Solution {
        var offset = 0
        return Solution { buffer ->
            val size = minOf(4, source.length - offset)
            for (i in 0 until size) {
                buffer[i] = source[offset + i]
            }
            offset += size
            size
        }
    }

    @Test
    fun preservesBufferedCharactersAcrossCalls() {
        val solution = reader("abcdefghij")
        val first = CharArray(2)
        val second = CharArray(3)
        val third = CharArray(4)
        val fourth = CharArray(10)
        assertEquals(2, solution.read(first, first.size))
        assertEquals("ab", String(first))
        assertEquals(3, solution.read(second, second.size))
        assertEquals("cde", String(second))
        assertEquals(4, solution.read(third, third.size))
        assertEquals("fghi", String(third))
        assertEquals(1, solution.read(fourth, fourth.size))
        assertEquals('j', fourth[0])
        assertEquals(0, solution.read(fourth, fourth.size))
    }

    @Test
    fun zeroLengthCallsDoNotConsumeInput() {
        val solution = reader("abcdef")
        val first = CharArray(1)
        val remaining = CharArray(5)
        assertEquals(0, solution.read(first, 0))
        assertEquals(1, solution.read(first, 1))
        assertEquals(0, solution.read(remaining, 0))
        assertEquals(5, solution.read(remaining, 5))
        assertEquals("a", String(first))
        assertEquals("bcdef", String(remaining))
    }

    @Test
    fun handlesSourcesShorterThanFourCharacters() {
        val buffer = CharArray(8)
        assertEquals(3, reader("xyz").read(buffer, 8))
        assertEquals("xyz", String(buffer, 0, 3))
        assertEquals(0, reader("").read(buffer, 8))
    }
}
