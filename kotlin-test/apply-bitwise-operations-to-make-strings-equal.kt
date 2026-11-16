package applybitwiseoperationstomakestringsequal

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

class ApplyBitwiseOperationsToMakeStringsEqualTest {
    private val solution = Solution()

    @Test
    fun bothStringsContainOne() {
        assertTrue(solution.makeStringsEqual("1010", "0110"))
    }

    @Test
    fun onlySourceContainsOne() {
        assertFalse(solution.makeStringsEqual("11", "00"))
    }

    @Test
    fun onlyTargetContainsOne() {
        assertFalse(solution.makeStringsEqual("0", "1"))
    }

    @Test
    fun neitherStringContainsOne() {
        assertTrue(solution.makeStringsEqual("000", "0"))
    }
}
