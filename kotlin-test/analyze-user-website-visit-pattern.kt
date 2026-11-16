package analyzeuserwebsitevisitpattern

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AnalyzeUserWebsiteVisitPatternTest {
    @Test
    fun testExample1() {
        val username = listOf("joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary")
        val timestamp = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val website = listOf("home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career")
        assertEquals(
            listOf("home", "about", "career"),
            Solution().mostVisitedPattern(username, timestamp, website)
        )
    }

    @Test
    fun testExample2() {
        val username = listOf("ua", "ua", "ua", "ub", "ub", "ub")
        val timestamp = listOf(1, 2, 3, 4, 5, 6)
        val website = listOf("a", "b", "a", "a", "b", "c")
        assertEquals(
            listOf("a", "b", "a"),
            Solution().mostVisitedPattern(username, timestamp, website)
        )
    }

    @Test
    fun testSingleUser() {
        val username = listOf("u", "u", "u")
        val timestamp = listOf(3, 1, 2)
        val website = listOf("c", "a", "b")
        assertEquals(
            listOf("a", "b", "c"),
            Solution().mostVisitedPattern(username, timestamp, website)
        )
    }

    @Test
    fun testTieBreakLexicographic() {
        val username = listOf("u1", "u1", "u1", "u2", "u2", "u2")
        val timestamp = listOf(1, 2, 3, 4, 5, 6)
        val website = listOf("z", "y", "x", "a", "b", "c")
        assertEquals(
            listOf("a", "b", "c"),
            Solution().mostVisitedPattern(username, timestamp, website)
        )
    }
}
