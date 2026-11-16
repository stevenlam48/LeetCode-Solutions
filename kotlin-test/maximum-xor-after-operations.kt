package maximumxorafteroperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumXorAfterOperationsTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(7, solution.maximumXOR(intArrayOf(3, 2, 4, 6)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(3, solution.maximumXOR(intArrayOf(1, 2, 3)))
    }

    @Test
    fun singleZero() {
        assertEquals(0, solution.maximumXOR(intArrayOf(0)))
    }

    @Test
    fun duplicatedBits() {
        assertEquals(5, solution.maximumXOR(intArrayOf(4, 5, 4)))
    }
}
