package countthenumberofsubstringswithdominantones

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTheNumberOfSubstringsWithDominantOnesTest {
    private val solution = Solution()

    @Test
    fun `first leetcode example`() {
        assertEquals(5, solution.numberOfSubstrings("00011"))
    }

    @Test
    fun `second leetcode example`() {
        assertEquals(16, solution.numberOfSubstrings("101101"))
    }

    @Test
    fun `all ones count every substring`() {
        assertEquals(10, solution.numberOfSubstrings("1111"))
    }

    @Test
    fun `all zeros have no dominant substring`() {
        assertEquals(0, solution.numberOfSubstrings("0000"))
    }

    @Test
    fun `short alternating string`() {
        assertEquals(5, solution.numberOfSubstrings("101"))
    }
}
