package elementappearingmorethan25insortedarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ElementAppearingMoreThan25InSortedArrayTest {
    @Test
    fun example() {
        assertEquals(6, Solution().findSpecialInteger(intArrayOf(1, 2, 2, 6, 6, 6, 6, 7, 10)))
    }

    @Test
    fun frequentValueAtStart() {
        assertEquals(1, Solution().findSpecialInteger(intArrayOf(1, 1, 1, 1, 2, 3, 4, 5)))
    }

    @Test
    fun exactlyTwentyFivePercentIsInsufficient() {
        assertEquals(-1, Solution().findSpecialInteger(intArrayOf(2, 2, 3, 3, 4, 4, 5, 5)))
    }

    @Test
    fun singleElement() {
        assertEquals(9, Solution().findSpecialInteger(intArrayOf(9)))
    }
}
