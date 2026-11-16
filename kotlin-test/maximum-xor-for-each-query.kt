package maximumxorforeachquery

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumXorForEachQueryTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertArrayEquals(
            intArrayOf(0, 3, 2, 3),
            solution.getMaximumXor(intArrayOf(0, 1, 1, 3), 2)
        )
    }

    @Test
    fun exampleTwo() {
        assertArrayEquals(
            intArrayOf(5, 2, 6, 5),
            solution.getMaximumXor(intArrayOf(2, 3, 4, 7), 3)
        )
    }

    @Test
    fun exampleThree() {
        assertArrayEquals(
            intArrayOf(4, 3, 6, 4, 6, 7),
            solution.getMaximumXor(intArrayOf(0, 1, 2, 2, 5, 7), 3)
        )
    }

    @Test
    fun singleElement() {
        assertArrayEquals(
            intArrayOf(1),
            solution.getMaximumXor(intArrayOf(0), 1)
        )
    }
}
