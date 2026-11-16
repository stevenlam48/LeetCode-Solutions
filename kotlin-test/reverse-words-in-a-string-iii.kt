package reversewordsinastringiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseWordsInAStringIiiTest {
    @Test
    fun exampleOne() {
        assertEquals("s'teL ekat edoCteeL tsetnoc", Solution().reverseWords("Let's take LeetCode contest"))
    }

    @Test
    fun exampleTwo() {
        assertEquals("rM gniD", Solution().reverseWords("Mr Ding"))
    }

    @Test
    fun singleWord() {
        assertEquals("olleh", Solution().reverseWords("hello"))
    }

    @Test
    fun emptyString() {
        assertEquals("", Solution().reverseWords(""))
    }
}
