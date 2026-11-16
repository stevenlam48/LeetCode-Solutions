package maximizeconsecutiveelementsinanarrayaftermodification

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeConsecutiveElementsInAnArrayAfterModificationTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.maxSelectedElements(intArrayOf(2, 1, 5, 1, 1)))
    }

    @Test
    fun testAlreadyConsecutive() {
        assertEquals(5, solution.maxSelectedElements(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun testAllEqual() {
        assertEquals(2, solution.maxSelectedElements(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, solution.maxSelectedElements(intArrayOf(5)))
    }

    @Test
    fun testGaps() {
        assertEquals(2, solution.maxSelectedElements(intArrayOf(1, 3, 5)))
    }
}
