package camelcasematching

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CamelcaseMatchingTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val queries = listOf("FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack")
        assertEquals(listOf(true, false, true, true, false), solution.camelMatch(queries, "FB"))
    }

    @Test
    fun testExample2() {
        val queries = listOf("FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack")
        assertEquals(listOf(true, false, true, false, false), solution.camelMatch(queries, "FoBa"))
    }

    @Test
    fun testExample3() {
        val queries = listOf("FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack")
        assertEquals(listOf(false, true, false, false, false), solution.camelMatch(queries, "FoBaT"))
    }

    @Test
    fun testEmptyQueries() {
        assertEquals(emptyList<Boolean>(), solution.camelMatch(emptyList(), "A"))
    }

    @Test
    fun testExactMatch() {
        assertEquals(listOf(true), solution.camelMatch(listOf("ABC"), "ABC"))
        assertEquals(listOf(false), solution.camelMatch(listOf("ABc"), "ABC"))
    }
}
