package maximumpossiblenumberbybinaryconcatenation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPossibleNumberByBinaryConcatenationTest {
    @Test
    fun standardExample() {
        assertEquals(30, Solution().maxGoodNumber(intArrayOf(1, 2, 3)))
    }

    @Test
    fun comparesConcatenatedBinaryStrings() {
        assertEquals(52, Solution().maxGoodNumber(intArrayOf(4, 2, 1)))
    }

    @Test
    fun equalValues() {
        assertEquals(7, Solution().maxGoodNumber(intArrayOf(1, 1, 1)))
    }

    @Test
    fun singleValue() {
        assertEquals(7, Solution().maxGoodNumber(intArrayOf(7)))
    }
}
