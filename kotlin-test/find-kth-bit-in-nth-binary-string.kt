package findkthbitinnthbinarystring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindKthBitInNthBinaryStringTest {
    @Test
    fun findsBitInThirdString() {
        assertEquals('0', Solution().findKthBit(3, 5))
    }

    @Test
    fun findsBitInFourthString() {
        assertEquals('1', Solution().findKthBit(4, 11))
    }

    @Test
    fun handlesFirstAndMiddlePositions() {
        assertEquals('0', Solution().findKthBit(1, 1))
        assertEquals('0', Solution().findKthBit(5, 1))
        assertEquals('1', Solution().findKthBit(5, 16))
    }
}
