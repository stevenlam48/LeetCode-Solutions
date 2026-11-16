package makethestringgreat

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MakeTheStringGreatTest {
    @Test
    fun testExample1() {
        assertEquals("leetcode", Solution().makeGood("leEeetcode"))
    }

    @Test
    fun testExample2() {
        assertEquals("", Solution().makeGood("abBAcC"))
    }

    @Test
    fun testExample3() {
        assertEquals("s", Solution().makeGood("s"))
    }

    @Test
    fun testSinglePair() {
        assertEquals("", Solution().makeGood("Pp"))
    }

    @Test
    fun testCascadingRemoval() {
        assertEquals("", Solution().makeGood("aAbB"))
    }

    @Test
    fun testSameCaseKept() {
        assertEquals("aabb", Solution().makeGood("aabb"))
    }
}
