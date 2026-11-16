package finduniquebinarystring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindUniqueBinaryStringTest {
    @Test
    fun exampleOne() {
        assertEquals("11", Solution().findDifferentBinaryString(listOf("01", "10")))
    }

    @Test
    fun exampleTwo() {
        assertEquals("10", Solution().findDifferentBinaryString(listOf("00", "01")))
    }

    @Test
    fun exampleThree() {
        assertEquals("000", Solution().findDifferentBinaryString(listOf("111", "011", "001")))
    }

    @Test
    fun singleZero() {
        assertEquals("1", Solution().findDifferentBinaryString(listOf("0")))
    }
}
