package binarystringwithsubstringsrepresenting1ton

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BinaryStringWithSubstringsRepresenting1ToNTest {
    @Test
    fun allRequiredNumbersArePresent() {
        assertTrue(Solution().queryString("0110", 3))
    }

    @Test
    fun requiredNumberIsMissing() {
        assertFalse(Solution().queryString("0110", 4))
    }

    @Test
    fun oneIsTheOnlyRequiredNumber() {
        assertTrue(Solution().queryString("0", 0))
        assertTrue(Solution().queryString("1", 1))
        assertFalse(Solution().queryString("0", 1))
    }

    @Test
    fun upperNumbersAreOutsideThePossibleRange() {
        assertFalse(Solution().queryString("1", 2))
    }
}
