package advantageshuffle

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class AdvantageShuffleTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertArrayEquals(
            intArrayOf(2, 11, 7, 15),
            solution.advantageCount(intArrayOf(2, 7, 11, 15), intArrayOf(1, 10, 4, 11))
        )
    }

    @Test
    fun secondExample() {
        assertArrayEquals(
            intArrayOf(24, 32, 8, 12),
            solution.advantageCount(intArrayOf(12, 24, 8, 32), intArrayOf(13, 25, 32, 11))
        )
    }

    @Test
    fun duplicateValues() {
        assertArrayEquals(
            intArrayOf(3, 3, 2, 1),
            solution.advantageCount(intArrayOf(1, 2, 3, 3), intArrayOf(2, 2, 0, 0))
        )
    }

    @Test
    fun noAdvantagesAvailable() {
        assertArrayEquals(intArrayOf(2, 1), solution.advantageCount(intArrayOf(1, 2), intArrayOf(3, 3)))
    }
}
