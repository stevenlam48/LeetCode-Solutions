package maximumxorwithanelementfromarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumXorWithAnElementFromArrayTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        val nums = intArrayOf(0, 1, 2, 3, 4)
        val queries = arrayOf(intArrayOf(3, 1), intArrayOf(1, 3), intArrayOf(5, 6))
        assertArrayEquals(intArrayOf(3, 3, 7), solution.maximizeXor(nums, queries))
    }

    @Test
    fun exampleTwo() {
        val nums = intArrayOf(5, 2, 4, 6, 6, 3)
        val queries = arrayOf(intArrayOf(12, 4), intArrayOf(8, 1), intArrayOf(6, 3))
        assertArrayEquals(intArrayOf(15, -1, 5), solution.maximizeXor(nums, queries))
    }

    @Test
    fun singleElement() {
        val nums = intArrayOf(0)
        val queries = arrayOf(intArrayOf(0, 0))
        assertArrayEquals(intArrayOf(0), solution.maximizeXor(nums, queries))
    }

    @Test
    fun limitBelowAllElements() {
        val nums = intArrayOf(4, 5)
        val queries = arrayOf(intArrayOf(1, 3))
        assertArrayEquals(intArrayOf(-1), solution.maximizeXor(nums, queries))
    }
}
