package removetrailingzerosfromastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveTrailingZerosFromAStringTest {
    private val solution = Solution()

    @Test
    fun removesSeveralTrailingZeros() {
        assertEquals("512301", solution.removeTrailingZeros("51230100"))
    }

    @Test
    fun keepsOtherZeros() {
        assertEquals("100203", solution.removeTrailingZeros("100203"))
    }

    @Test
    fun reducesPowersOfTenToOne() {
        assertEquals("1", solution.removeTrailingZeros("1000"))
    }
}
