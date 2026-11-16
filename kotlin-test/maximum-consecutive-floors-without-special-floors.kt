package maximumconsecutivefloorswithoutspecialfloors

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumConsecutiveFloorsWithoutSpecialFloorsTest {
    @Test
    fun example() {
        assertEquals(3, Solution().maxConsecutive(2, 9, intArrayOf(4, 6)))
    }

    @Test
    fun allSpecial() {
        assertEquals(0, Solution().maxConsecutive(6, 8, intArrayOf(7, 6, 8)))
    }

    @Test
    fun gapInTheMiddle() {
        assertEquals(1, Solution().maxConsecutive(1, 5, intArrayOf(2, 4)))
    }

    @Test
    fun singleSpecial() {
        assertEquals(5, Solution().maxConsecutive(1, 10, intArrayOf(5)))
    }
}
