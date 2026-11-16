package ksimilarstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KSimilarStringsTest {
    @Test
    fun `one swap makes strings equal`() {
        assertEquals(1, Solution().kSimilarity("ab", "ba"))
    }

    @Test
    fun `rotation requires two swaps`() {
        assertEquals(2, Solution().kSimilarity("abc", "bca"))
    }

    @Test
    fun `repeated characters example`() {
        assertEquals(2, Solution().kSimilarity("abac", "baca"))
    }

    @Test
    fun `identical strings need no swaps`() {
        assertEquals(0, Solution().kSimilarity("aabb", "aabb"))
    }

    @Test
    fun `handles duplicated swap candidates`() {
        assertEquals(2, Solution().kSimilarity("aabb", "bbaa"))
    }
}
