package checkifitisagoodarray

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfItIsAGoodArrayTest {
    private val solution = Solution()

    @Test
    fun overallGcdIsOne() {
        assertTrue(solution.isGoodArray(intArrayOf(12, 5, 7, 23)))
    }

    @Test
    fun sharedFactor() {
        assertFalse(solution.isGoodArray(intArrayOf(3, 6)))
    }

    @Test
    fun singleOne() {
        assertTrue(solution.isGoodArray(intArrayOf(1)))
    }

    @Test
    fun singleComposite() {
        assertFalse(solution.isGoodArray(intArrayOf(4)))
    }

    @Test
    fun noPairwiseCoprimeNumbersButGoodArray() {
        assertTrue(solution.isGoodArray(intArrayOf(6, 10, 15)))
    }
}
