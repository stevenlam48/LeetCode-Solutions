package minimizemaximumpairsuminarray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeMaximumPairSumInArrayTest {
    @Test
    fun firstExample() {
        assertEquals(7, Solution().minPairSum(intArrayOf(3, 5, 2, 3)))
    }

    @Test
    fun secondExample() {
        assertEquals(8, Solution().minPairSum(intArrayOf(3, 5, 4, 2, 4, 6)))
    }

    @Test
    fun duplicates() {
        assertEquals(2, Solution().minPairSum(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun twoElements() {
        assertEquals(9, Solution().minPairSum(intArrayOf(4, 5)))
    }

    @Test
    fun zeroesAndPositiveValues() {
        assertEquals(6, Solution().minPairSum(intArrayOf(0, 2, 4, 6)))
    }
}
