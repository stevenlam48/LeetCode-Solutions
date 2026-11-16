package validbinarystringswithcostlimit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidBinaryStringsWithCostLimitTest {
    @Test
    fun lengthTwoWithZeroCost() {
        assertEquals(listOf("00", "10"), Solution().generateValidStrings(2, 0))
    }

    @Test
    fun severalAllowedOnePositions() {
        assertEquals(listOf("000", "001", "010", "100", "101"), Solution().generateValidStrings(3, 2))
    }

    @Test
    fun lengthOneWithZeroCost() {
        assertEquals(listOf("0", "1"), Solution().generateValidStrings(1, 0))
    }

    @Test
    fun negativeCostAllowsOnlyAllZeros() {
        assertEquals(listOf("000"), Solution().generateValidStrings(3, -1))
    }
}
