package bitwiseandofnumbersrange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BitwiseAndOfNumbersRangeTest {
    @Test
    fun standardExample() {
        assertEquals(4, Solution().rangeBitwiseAnd(5, 7))
    }

    @Test
    fun zeroLowerBound() {
        assertEquals(0, Solution().rangeBitwiseAnd(0, 1))
    }

    @Test
    fun singleNumberRange() {
        assertEquals(12, Solution().rangeBitwiseAnd(12, 12))
    }

    @Test
    fun upperIntValues() {
        assertEquals(2_147_483_646, Solution().rangeBitwiseAnd(2_147_483_646, 2_147_483_647))
    }
}
