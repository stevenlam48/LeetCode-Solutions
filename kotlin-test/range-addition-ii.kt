package rangeadditionii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RangeAdditionIiTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val ops = arrayOf(intArrayOf(2, 2), intArrayOf(3, 3))
        assertEquals(4, solution.maxCount(3, 3, ops))
    }

    @Test
    fun testExample2() {
        val ops = arrayOf(
            intArrayOf(2, 2), intArrayOf(3, 3), intArrayOf(3, 3),
            intArrayOf(3, 3), intArrayOf(2, 2), intArrayOf(3, 3),
            intArrayOf(3, 3), intArrayOf(3, 3), intArrayOf(2, 2), intArrayOf(3, 3)
        )
        assertEquals(4, solution.maxCount(3, 3, ops))
    }

    @Test
    fun testExample3() {
        assertEquals(9, solution.maxCount(3, 3, arrayOf()))
    }

    @Test
    fun testSingleOp() {
        assertEquals(6, solution.maxCount(5, 5, arrayOf(intArrayOf(2, 3))))
    }
}
