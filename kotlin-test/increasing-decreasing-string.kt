package increasingdecreasingstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IncreasingDecreasingStringTest {
    @Test
    fun example1() {
        assertEquals("abccbaabccba", Solution().sortString("aaaabbbbcccc"))
    }

    @Test
    fun example2() {
        assertEquals("art", Solution().sortString("rat"))
    }

    @Test
    fun example3() {
        assertEquals("cdelotee", Solution().sortString("leetcode"))
    }

    @Test
    fun allSameCharacter() {
        assertEquals("ggggggg", Solution().sortString("ggggggg"))
    }

    @Test
    fun example5() {
        assertEquals("ops", Solution().sortString("spo"))
    }

    @Test
    fun emptyString() {
        assertEquals("", Solution().sortString(""))
    }
}
