package elementsinarrayafterremovingandreplacingelements

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ElementsInArrayAfterRemovingAndReplacingElementsTest {
    @Test
    fun allRemovalAndReplacementPhases() {
        val nums = intArrayOf(1, 2)
        val queries = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 0),
            intArrayOf(2, 0),
            intArrayOf(3, 0),
            intArrayOf(4, 1)
        )
        assertArrayEquals(intArrayOf(1, 2, -1, 1, 2), Solution().elementInNums(nums, queries))
    }

    @Test
    fun examplesWithIndices() {
        val nums = intArrayOf(1, 2)
        val queries = arrayOf(intArrayOf(0, 1), intArrayOf(2, 0), intArrayOf(4, 1))
        assertArrayEquals(intArrayOf(2, -1, 2), Solution().elementInNums(nums, queries))
    }

    @Test
    fun moduloAcrossSeveralCycles() {
        val nums = intArrayOf(10, 11, 12)
        val queries = arrayOf(intArrayOf(17, 1), intArrayOf(8, 0), intArrayOf(5, 2))
        assertArrayEquals(intArrayOf(11, 12, -1), Solution().elementInNums(nums, queries))
    }

    @Test
    fun duplicateValues() {
        val nums = intArrayOf(4, 4, 5)
        val queries = arrayOf(intArrayOf(0, 0), intArrayOf(1, 0), intArrayOf(2, 0))
        assertArrayEquals(intArrayOf(4, 4, 5), Solution().elementInNums(nums, queries))
    }
}
