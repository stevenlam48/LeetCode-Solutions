package countmentionsperuser

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountMentionsPerUserTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val events = arrayOf(
            arrayOf("MESSAGE", "10", "id1 id0"),
            arrayOf("OFFLINE", "11", "0"),
            arrayOf("MESSAGE", "71", "HERE")
        )
        assertArrayEquals(intArrayOf(2, 2), solution.countMentions(2, events))
    }

    @Test
    fun testExample2() {
        val events = arrayOf(
            arrayOf("MESSAGE", "10", "id1 id0"),
            arrayOf("OFFLINE", "11", "0"),
            arrayOf("MESSAGE", "12", "ALL")
        )
        assertArrayEquals(intArrayOf(2, 2), solution.countMentions(2, events))
    }

    @Test
    fun testExample3() {
        val events = arrayOf(
            arrayOf("MESSAGE", "10", "id1 id0"),
            arrayOf("OFFLINE", "11", "0"),
            arrayOf("MESSAGE", "12", "HERE")
        )
        assertArrayEquals(intArrayOf(1, 2), solution.countMentions(2, events))
    }

    @Test
    fun testMultipleMentionsInOneMessage() {
        val events = arrayOf(
            arrayOf("MESSAGE", "1", "id0 id1 id2")
        )
        assertArrayEquals(intArrayOf(1, 1, 1), solution.countMentions(3, events))
    }

    @Test
    fun testOfflineExpiresAtExactTime() {
        val events = arrayOf(
            arrayOf("OFFLINE", "5", "0"),
            arrayOf("MESSAGE", "65", "HERE")
        )
        assertArrayEquals(intArrayOf(1), solution.countMentions(1, events))
    }
}
