package addbinary

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PaddbinaryTest {
    @Test
    fun example1() {
        assertEquals("100", Solution().addBinary("11", "1"))
    }

    @Test
    fun example2() {
        assertEquals("10101", Solution().addBinary("1010", "1011"))
    }

    @Test
    fun zeros() {
        assertEquals("0", Solution().addBinary("0", "0"))
    }

    @Test
    fun differentLengths() {
        assertEquals("1000", Solution().addBinary("1", "111"))
    }

    @Test
    fun carryAllTheWay() {
        assertEquals("10000", Solution().addBinary("1111", "1"))
    }
}
