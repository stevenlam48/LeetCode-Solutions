package specialarrayi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SpecialArrayITest {
    @Test
    fun singleElement() {
        assertTrue(Solution().isArraySpecial(intArrayOf(1)))
    }

    @Test
    fun alternatingParity() {
        assertTrue(Solution().isArraySpecial(intArrayOf(2, 1, 4)))
        assertTrue(Solution().isArraySpecial(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun twoEvenAdjacent() {
        assertFalse(Solution().isArraySpecial(intArrayOf(4, 3, 1, 6)))
    }

    @Test
    fun allEven() {
        assertFalse(Solution().isArraySpecial(intArrayOf(2, 4, 6)))
    }
}
