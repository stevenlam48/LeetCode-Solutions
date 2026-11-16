package converttobase2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConvertToBase2Test {
    private val solution = Solution()

    @Test
    fun testTwo() {
        assertEquals("110", solution.baseNeg2(2))
    }

    @Test
    fun testThree() {
        assertEquals("111", solution.baseNeg2(3))
    }

    @Test
    fun testFour() {
        assertEquals("100", solution.baseNeg2(4))
    }

    @Test
    fun testZero() {
        assertEquals("0", solution.baseNeg2(0))
    }
}
