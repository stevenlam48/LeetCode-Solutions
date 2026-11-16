package encodeanddecodetinyurl

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class EncodeAndDecodeTinyurlTest {
    @Test
    fun `encoded URL has six character alphanumeric key and round trips`() {
        val solution = Solution()
        val longUrl = "https://leetcode.com/problems/design-tinyurl"

        val shortUrl = solution.encode(longUrl)

        assertTrue(shortUrl.startsWith("http://tinyurl.com/"))
        assertTrue(shortUrl.removePrefix("http://tinyurl.com/").matches(Regex("[0-9A-Za-z]{6}")))
        assertEquals(longUrl, solution.decode(shortUrl))
    }

    @Test
    fun `different URLs retain their own mappings`() {
        val solution = Solution()
        val first = "https://example.com/first?a=1"
        val second = "https://example.com/second?b=2"

        val firstShort = solution.encode(first)
        val secondShort = solution.encode(second)

        assertNotEquals(firstShort, secondShort)
        assertEquals(first, solution.decode(firstShort))
        assertEquals(second, solution.decode(secondShort))
    }

    @Test
    fun `encoding the same URL twice creates independent mappings`() {
        val solution = Solution()
        val longUrl = "https://example.com/repeated"

        val firstShort = solution.encode(longUrl)
        val secondShort = solution.encode(longUrl)

        assertNotEquals(firstShort, secondShort)
        assertEquals(longUrl, solution.decode(firstShort))
        assertEquals(longUrl, solution.decode(secondShort))
    }

    @Test
    fun `empty URL round trips and unknown key decodes to empty`() {
        val solution = Solution()

        val shortUrl = solution.encode("")

        assertEquals("", solution.decode(shortUrl))
        assertEquals("", solution.decode("http://tinyurl.com/zzzzzz"))
    }
}
