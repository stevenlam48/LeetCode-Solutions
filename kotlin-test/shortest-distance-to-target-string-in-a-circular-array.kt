package shortestdistancetotargetstringinacirculararray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestDistanceToTargetStringInACircularArrayTest {
    @Test
    fun findsTargetNearStart() {
        val words = listOf("hello", "i", "love", "leetcode", "i", "love", "coding")
        assertEquals(1, Solution().closetTarget(words, "i", 0))
        assertEquals(1, Solution().closetTarget(words, "love", 3))
        assertEquals(1, Solution().closetTarget(words, "coding", 0))
    }

    @Test
    fun goesTheOtherWayAroundTheCircle() {
        assertEquals(1, Solution().closetTarget(listOf("a", "b", "c"), "c", 0))
        assertEquals(1, Solution().closetTarget(listOf("a", "b", "c"), "a", 1))
    }

    @Test
    fun returnsMinusOneWhenTargetIsAbsent() {
        assertEquals(-1, Solution().closetTarget(listOf("a", "b", "c"), "z", 1))
    }

    @Test
    fun handlesSingleWord() {
        assertEquals(0, Solution().closetTarget(listOf("a"), "a", 0))
    }
}
