package takegiftsfromtherichestpile

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TakeGiftsFromTheRichestPileTest {
    @Test
    fun standardExample() {
        assertEquals(29L, Solution().pickGifts(intArrayOf(25, 64, 9, 4, 100), 4))
    }

    @Test
    fun repeatedSquareRoots() {
        assertEquals(5L, Solution().pickGifts(intArrayOf(1, 16, 4), 3))
    }

    @Test
    fun noOperations() {
        assertEquals(6L, Solution().pickGifts(intArrayOf(1, 2, 3), 0))
    }
}
