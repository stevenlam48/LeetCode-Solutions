package minimumnumberofoperationstomoveallballstoeachbox

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToMoveAllBallsToEachBoxTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertArrayEquals(intArrayOf(1, 1, 3), solution.minOperations("110"))
    }

    @Test
    fun secondExample() {
        assertArrayEquals(intArrayOf(11, 8, 5, 4, 3, 4), solution.minOperations("001011"))
    }

    @Test
    fun emptyBoxes() {
        assertArrayEquals(IntArray(0), solution.minOperations(""))
    }

    @Test
    fun singleBox() {
        assertArrayEquals(intArrayOf(0), solution.minOperations("1"))
    }

    @Test
    fun noBalls() {
        assertArrayEquals(intArrayOf(0, 0, 0), solution.minOperations("000"))
    }

    @Test
    fun alternatingBalls() {
        assertArrayEquals(intArrayOf(6, 5, 4, 5, 6), solution.minOperations("10101"))
    }
}
