package countintegersappearinginasingleblock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountIntegersAppearingInASingleBlockTest {
    private val solution = Solution()

    @Test
    fun excludesValueAppearingInTwoBlocks() {
        assertEquals(2, solution.countSpecialIntegers(intArrayOf(1, 2, 2, 1, 3)))
    }

    @Test
    fun handlesAdjacentDuplicateBlocks() {
        assertEquals(2, solution.countSpecialIntegers(intArrayOf(1, 1, 2, 2, 1, 3, 3)))
    }

    @Test
    fun singleBlockIsAlwaysSpecial() {
        assertEquals(1, solution.countSpecialIntegers(intArrayOf(4, 4, 4)))
    }
}
