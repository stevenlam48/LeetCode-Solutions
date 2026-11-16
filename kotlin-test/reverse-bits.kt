package reversebits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseBitsTest {
    @Test
    fun example() {
        assertEquals(964176192, Solution().reverseBits(43261596))
    }

    @Test
    fun zero() {
        assertEquals(0, Solution().reverseBits(0))
    }

    @Test
    fun one() {
        assertEquals(Int.MIN_VALUE, Solution().reverseBits(1))
    }

    @Test
    fun allOnes() {
        assertEquals(-1, Solution().reverseBits(-1))
    }

    @Test
    fun highBitPattern() {
        assertEquals(0xBFFFFFFFL.toInt(), Solution().reverseBits(0xFFFFFFFDL.toInt()))
    }
}
