package generateastringwithcharactersthathaveoddcounts

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GenerateAStringWithCharactersThatHaveOddCountsTest {
    private fun assertOddCounts(s: String, n: Int) {
        assertEquals(n, s.length)
        val counts = s.groupingBy { it }.eachCount()
        for (count in counts.values) {
            assertTrue(count % 2 != 0)
        }
    }

    @Test
    fun one() {
        assertEquals("a", Solution().generateTheString(1))
    }

    @Test
    fun two() {
        val result = Solution().generateTheString(2)
        assertEquals(2, result.length)
        assertOddCounts(result, 2)
    }

    @Test
    fun four() {
        assertEquals("aaab", Solution().generateTheString(4))
    }

    @Test
    fun seven() {
        assertEquals("aaaaaaa", Solution().generateTheString(7))
    }

    @Test
    fun oddCountsForRange() {
        for (n in 1..20) {
            assertOddCounts(Solution().generateTheString(n), n)
        }
    }
}
