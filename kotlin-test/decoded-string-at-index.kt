package decodedstringatindex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecodedStringAtIndexTest {
    @Test
    fun example1() {
        assertEquals("o", Solution().decodeAtIndex("leet2code3", 10))
    }

    @Test
    fun example2() {
        assertEquals("h", Solution().decodeAtIndex("ha22", 5))
    }

    @Test
    fun example3() {
        assertEquals("a", Solution().decodeAtIndex("a2345678999999999999999", 1))
    }

    @Test
    fun plainString() {
        assertEquals("a", Solution().decodeAtIndex("abc", 1))
        assertEquals("c", Solution().decodeAtIndex("abc", 3))
    }

    @Test
    fun repeatedTail() {
        assertEquals("a", Solution().decodeAtIndex("a2b3", 5))
    }
}
