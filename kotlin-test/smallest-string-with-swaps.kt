package smalleststringwithswaps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestStringWithSwapsTest {
    private val solution = Solution()

    @Test
    fun examples() {
        val pairs = arrayOf(intArrayOf(0, 3), intArrayOf(1, 2))
        assertEquals("bacd", solution.smallestStringWithSwaps("dcab", pairs))
        val connected = arrayOf(intArrayOf(0, 3), intArrayOf(1, 2), intArrayOf(0, 2))
        assertEquals("abcd", solution.smallestStringWithSwaps("dcab", connected))
    }

    @Test
    fun noSwaps() {
        assertEquals("dcab", solution.smallestStringWithSwaps("dcab", emptyArray()))
    }

    @Test
    fun connectedComponentWithRepeatedCharacters() {
        val pairs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals("aab", solution.smallestStringWithSwaps("baa", pairs))
    }

    @Test
    fun disconnectedIndicesKeepTheirCharacters() {
        val pairs = arrayOf(intArrayOf(0, 2))
        assertEquals("abc", solution.smallestStringWithSwaps("cba", pairs))
    }
}
