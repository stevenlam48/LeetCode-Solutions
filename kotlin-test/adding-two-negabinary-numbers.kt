package addingtwonegabinarynumbers

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class AddingTwoNegabinaryNumbersTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertArrayEquals(
            intArrayOf(1, 0, 0, 0, 0),
            solution.addNegabinary(intArrayOf(1, 1, 1, 1, 1), intArrayOf(1, 0, 1))
        )
    }

    @Test
    fun zeros() {
        assertArrayEquals(intArrayOf(0), solution.addNegabinary(intArrayOf(0), intArrayOf(0)))
    }

    @Test
    fun positiveCarryChain() {
        assertArrayEquals(intArrayOf(1, 1, 0), solution.addNegabinary(intArrayOf(1), intArrayOf(1)))
    }

    @Test
    fun negativeCarryChain() {
        assertArrayEquals(
            intArrayOf(1, 1, 0, 1, 0),
            solution.addNegabinary(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1))
        )
    }

    @Test
    fun leadingZerosAreRemoved() {
        assertArrayEquals(intArrayOf(0), solution.addNegabinary(intArrayOf(1), intArrayOf(1, 1)))
    }
}
