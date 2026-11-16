package reversestringii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseStringIiTest {
    @Test
    fun exampleOne() {
        assertEquals("bacdfeg", Solution().reverseStr("abcdefg", 2))
    }

    @Test
    fun exampleTwo() {
        assertEquals("bacd", Solution().reverseStr("abcd", 2))
    }

    @Test
    fun kExceedsStringLength() {
        assertEquals("dcba", Solution().reverseStr("abcd", 8))
    }

    @Test
    fun kIsOne() {
        assertEquals("abcd", Solution().reverseStr("abcd", 1))
    }
}
