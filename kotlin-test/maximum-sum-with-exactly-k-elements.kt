package maximumsumwithexactlykelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumWithExactlyKElementsTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(18, solution.maximizeSum(intArrayOf(1, 2, 3, 4, 5), 3))
    }

    @Test
    fun allEqual() {
        assertEquals(11, solution.maximizeSum(intArrayOf(5, 5, 5), 2))
    }

    @Test
    fun singleElement() {
        assertEquals(1, solution.maximizeSum(intArrayOf(1), 1))
    }

    @Test
    fun largeK() {
        assertEquals(55, solution.maximizeSum(intArrayOf(9, 1), 5))
    }
}
