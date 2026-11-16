package constructstringwithrepeatlimit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstructStringWithRepeatLimitTest {
    @Test
    fun testExample1() {
        assertEquals("zzcccac", Solution().repeatLimitedString("cczazcc", 3))
    }

    @Test
    fun testExample2() {
        assertEquals("bbabaa", Solution().repeatLimitedString("aababab", 2))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals("a", Solution().repeatLimitedString("a", 1))
    }

    @Test
    fun testLimitOne() {
        assertEquals("ba", Solution().repeatLimitedString("aab", 1))
        assertEquals("baba", Solution().repeatLimitedString("aabb", 1))
    }

    @Test
    fun testAllSameCharacter() {
        assertEquals("aa", Solution().repeatLimitedString("aaaa", 2))
    }
}
