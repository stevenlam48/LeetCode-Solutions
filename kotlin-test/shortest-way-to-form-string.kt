package shortestwaytoformstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShortestWayToFormStringTest {
    private val solution = Solution()

    @Test
    fun `uses two source subsequences`() {
        assertEquals(2, solution.shortestWay("abc", "abcbc"))
    }

    @Test
    fun `returns minus one for missing character`() {
        assertEquals(-1, solution.shortestWay("abc", "acdbc"))
    }

    @Test
    fun `restarts source whenever needed`() {
        assertEquals(3, solution.shortestWay("xyz", "xzyxz"))
    }

    @Test
    fun `empty target still uses one subsequence`() {
        assertEquals(1, solution.shortestWay("abc", ""))
    }
}
