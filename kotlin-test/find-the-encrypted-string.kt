package findtheencryptedstring

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheEncryptedStringTest {
    @Test
    fun rotatesByThree() {
        assertEquals("tdar", Solution().getEncryptedString("dart", 3))
    }

    @Test
    fun handlesUniformString() {
        assertEquals("aaa", Solution().getEncryptedString("aaa", 1))
    }

    @Test
    fun handlesZeroShift() {
        assertEquals("abc", Solution().getEncryptedString("abc", 0))
    }

    @Test
    fun reducesShiftModuloLength() {
        assertEquals("cdab", Solution().getEncryptedString("abcd", 6))
    }
}
