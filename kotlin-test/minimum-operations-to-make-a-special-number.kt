package minimumoperationstomakeaspecialnumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeASpecialNumberTest {
    @Test
    fun testAlreadySpecial() {
        assertEquals(0, Solution().minimumOperations("2250"))
    }

    @Test
    fun testDeleteSuffix() {
        assertEquals(1, Solution().minimumOperations("290501"))
    }

    @Test
    fun testDeleteMiddleDigit() {
        assertEquals(1, Solution().minimumOperations("505"))
    }

    @Test
    fun testNoUsableSuffix() {
        assertEquals(3, Solution().minimumOperations("123"))
    }
}
