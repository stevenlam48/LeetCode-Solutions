package decodetheslantedciphertext

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecodeTheSlantedCiphertextTest {
    @Test
    fun example1() {
        assertEquals("cipher", Solution().decodeCiphertext("ch   ie   pr", 3))
    }

    @Test
    fun twoRows() {
        assertEquals("acbd", Solution().decodeCiphertext("ab  cd", 2))
    }

    @Test
    fun emptyText() {
        assertEquals("", Solution().decodeCiphertext("", 1))
    }

    @Test
    fun singleRow() {
        assertEquals("hello", Solution().decodeCiphertext("hello", 1))
    }

    @Test
    fun singleChar() {
        assertEquals("a", Solution().decodeCiphertext("a", 1))
    }

    @Test
    fun trailingSpacesTrimmed() {
        assertEquals("a b", Solution().decodeCiphertext("a b ", 1))
    }
}
