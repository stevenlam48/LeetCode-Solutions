package finalelementaftersubarraydeletions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FinalElementAfterSubarrayDeletionsTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().finalElement(intArrayOf(1, 3, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(5, Solution().finalElement(intArrayOf(5)))
    }

    @Test
    fun twoEqualElements() {
        assertEquals(2, Solution().finalElement(intArrayOf(2, 2)))
    }

    @Test
    fun interiorMaximumIsIgnored() {
        assertEquals(2, Solution().finalElement(intArrayOf(1, 100, 2)))
    }

    @Test
    fun lastElementIsLarger() {
        assertEquals(9, Solution().finalElement(intArrayOf(4, 5, 6, 9)))
    }
}
