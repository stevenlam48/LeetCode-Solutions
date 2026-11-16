package xoroperationinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class XorOperationInAnArrayTest {
    @Test
    fun examples() {
        assertEquals(8, Solution().xorOperation(5, 0))
        assertEquals(8, Solution().xorOperation(4, 3))
    }

    @Test
    fun singleElement() {
        assertEquals(7, Solution().xorOperation(1, 7))
        assertEquals(0, Solution().xorOperation(1, 0))
    }

    @Test
    fun oddStartAndLength() {
        assertEquals(11, Solution().xorOperation(3, 5))
    }

    @Test
    fun largerInput() {
        var expected = 0
        for (i in 0 until 10) expected = expected xor (6 + 2 * i)
        assertEquals(expected, Solution().xorOperation(10, 6))
    }
}
