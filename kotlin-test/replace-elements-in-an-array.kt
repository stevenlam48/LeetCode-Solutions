package replaceelementsinanarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ReplaceElementsInAnArrayTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        val operations = arrayOf(
            intArrayOf(1, 3), intArrayOf(2, 1), intArrayOf(4, 7)
        )
        assertArrayEquals(
            intArrayOf(3, 1, 7, 6),
            solution.arrayChange(intArrayOf(1, 2, 4, 6), operations)
        )
    }

    @Test
    fun valuesCanBeReusedByLaterOperations() {
        val operations = arrayOf(
            intArrayOf(1, 3), intArrayOf(2, 1), intArrayOf(3, 2)
        )
        assertArrayEquals(
            intArrayOf(2, 1),
            solution.arrayChange(intArrayOf(1, 2), operations)
        )
    }

    @Test
    fun singleElementCanBeReplaced() {
        val operations = arrayOf(intArrayOf(1, 2))
        assertArrayEquals(intArrayOf(2), solution.arrayChange(intArrayOf(1), operations))
    }

    @Test
    fun noOperationsLeaveArrayUnchanged() {
        assertArrayEquals(
            intArrayOf(-1, 0, 3),
            solution.arrayChange(intArrayOf(-1, 0, 3), emptyArray())
        )
    }
}
