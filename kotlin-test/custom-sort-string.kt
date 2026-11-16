package customsortstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CustomSortStringTest {
    @Test
    fun example1() {
        assertEquals("cbad", Solution().customSortString("cba", "abcd"))
    }

    @Test
    fun example2() {
        assertEquals("bcad", Solution().customSortString("bcafg", "abcd"))
    }

    @Test
    fun sameOrder() {
        assertEquals("abcd", Solution().customSortString("abcd", "abcd"))
    }

    @Test
    fun emptyT() {
        assertEquals("", Solution().customSortString("cba", ""))
    }

    @Test
    fun leftoverNotInS() {
        assertEquals("aabb", Solution().customSortString("xyz", "aabb"))
    }

    @Test
    fun repeatedChars() {
        assertEquals("ccbbaa", Solution().customSortString("cba", "abcabc"))
    }
}
