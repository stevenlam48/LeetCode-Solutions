package minimumarrayend

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumArrayEndTest {
    @Test
    fun standardExample() = assertEquals(6L, Solution().minEnd(3, 4))

    @Test
    fun consecutiveOneBits() = assertEquals(15L, Solution().minEnd(2, 7))

    @Test
    fun singleElement() = assertEquals(5L, Solution().minEnd(1, 5))

    @Test
    fun fourthNumber() = assertEquals(7L, Solution().minEnd(4, 1))
}
