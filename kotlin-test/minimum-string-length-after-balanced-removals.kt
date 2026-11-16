package minimumstringlengthafterbalancedremovals

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumStringLengthAfterBalancedRemovalsTest {
    @Test
    fun `removes all characters when counts are balanced`() {
        assertEquals(0, Solution().minLengthAfterRemovals("aabbab"))
        assertEquals(0, Solution().minLengthAfterRemovals("abab"))
    }

    @Test
    fun `leaves the excess count of a`() {
        assertEquals(2, Solution().minLengthAfterRemovals("aaab"))
    }

    @Test
    fun `leaves the excess count of b`() {
        assertEquals(3, Solution().minLengthAfterRemovals("abbbb"))
    }

    @Test
    fun `handles empty and single-character strings`() {
        assertEquals(0, Solution().minLengthAfterRemovals(""))
        assertEquals(1, Solution().minLengthAfterRemovals("a"))
    }
}
