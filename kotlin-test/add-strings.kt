package addstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddStringsTest {
    private val solution = Solution()

    @Test
    fun sameLengthInputs() {
        assertEquals("134", solution.addStrings("11", "123"))
    }

    @Test
    fun differentLengthInputs() {
        assertEquals("533", solution.addStrings("456", "77"))
    }

    @Test
    fun zeros() {
        assertEquals("0", solution.addStrings("0", "0"))
    }

    @Test
    fun carryExtendsResult() {
        assertEquals("10000", solution.addStrings("9999", "1"))
    }

    @Test
    fun longInputs() {
        assertEquals("100000000000000000000", solution.addStrings("99999999999999999999", "1"))
    }
}
