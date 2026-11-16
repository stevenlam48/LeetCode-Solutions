package encodeanddecodestrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EncodeAndDecodeStringsTest {
    private val codec = Codec()

    @Test
    fun `empty list and empty encoded string round trip`() {
        assertEquals("", codec.encode(emptyList()))
        assertEquals(emptyList<String>(), codec.decode(""))
    }

    @Test
    fun `uses eight byte big endian length prefixes`() {
        val input = listOf("Hello", "World")
        val expected = "\u0000".repeat(7) + "\u0005Hello" +
            "\u0000".repeat(7) + "\u0005World"

        assertEquals(expected, codec.encode(input))
        assertEquals(input, codec.decode(expected))
    }

    @Test
    fun `round trips arbitrary Kotlin strings`() {
        val input = listOf(
            "",
            "\u0000",
            "a,b:c\u0000d",
            "é水😀",
            "\uD800",
            "line\nbreak\ttab"
        )

        assertEquals(input, codec.decode(codec.encode(input)))
    }

    @Test
    fun `framing supports lengths greater than one byte`() {
        val value = "a".repeat(300)
        val encoded = codec.encode(listOf(value))

        assertEquals(listOf(0, 0, 0, 0, 0, 0, 1, 44), encoded.take(8).map { it.code })
        assertEquals(listOf(value), codec.decode(encoded))
    }
}
