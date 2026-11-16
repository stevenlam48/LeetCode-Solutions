package minimumbitflipstoconvertnumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumBitFlipsToConvertNumberTest {
    @Test
    fun standardExample() = assertEquals(3, Solution().minBitFlips(10, 7))

    @Test
    fun disjointBits() = assertEquals(3, Solution().minBitFlips(3, 4))

    @Test
    fun equalNumbers() = assertEquals(0, Solution().minBitFlips(0, 0))

    @Test
    fun zeroToAllLowBits() = assertEquals(4, Solution().minBitFlips(0, 15))
}
