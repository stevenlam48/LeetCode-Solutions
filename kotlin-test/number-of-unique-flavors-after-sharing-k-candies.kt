package numberofuniqueflavorsaftersharingkcandies

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfUniqueFlavorsAfterSharingKCandiesTest {
    @Test
    fun example() {
        assertEquals(3, Solution().shareCandies(intArrayOf(1, 2, 2, 3, 4, 5), 3))
    }

    @Test
    fun shareAll() {
        assertEquals(0, Solution().shareCandies(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun shareNone() {
        assertEquals(3, Solution().shareCandies(intArrayOf(1, 2, 3), 0))
    }

    @Test
    fun allSameFlavor() {
        assertEquals(1, Solution().shareCandies(intArrayOf(1, 1, 1, 1), 2))
    }

    @Test
    fun twoFlavorsLeft() {
        assertEquals(2, Solution().shareCandies(intArrayOf(1, 2, 3, 4), 2))
    }
}
