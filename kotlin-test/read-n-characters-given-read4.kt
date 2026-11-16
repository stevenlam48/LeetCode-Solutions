package readncharactersgivenread4
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ReadNCharactersGivenRead4Test {
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
    fun readsRequestedCharacters() {
        val buffer = CharArray(10)
        val solution = reader("abcde")
        assertEquals(5, solution.read(buffer, 5))
        assertEquals("abcde", String(buffer, 0, 5))
    }

    @Test
    fun stopsAtEndOfSource() {
        val buffer = CharArray(10) { '_' }
        assertEquals(3, reader("abc").read(buffer, 10))
        assertEquals("abc", String(buffer, 0, 3))
        assertEquals('_', buffer[3])
    }

    @Test
    fun partialRead4AndZeroLengthRead() {
        val buffer = CharArray(5) { '_' }
        assertEquals(3, reader("abcde").read(buffer, 3))
        assertEquals("abc__", String(buffer))
        assertEquals(0, reader("abcde").read(buffer, 0))
        assertEquals("abc__", String(buffer))
    }

    @Test
    fun emptySource() {
        assertEquals(0, reader("").read(CharArray(4), 4))
    }
}
