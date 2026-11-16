package minimummoneyrequiredbeforetransactions

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumMoneyRequiredBeforeTransactionsTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(10L, solution.minimumMoney(
            arrayOf(intArrayOf(2, 1), intArrayOf(5, 0), intArrayOf(4, 2))
        ))
    }

    @Test
    fun testExample2() {
        assertEquals(3L, solution.minimumMoney(
            arrayOf(intArrayOf(3, 0), intArrayOf(0, 3))
        ))
    }

    @Test
    fun testSingleProfitable() {
        assertEquals(0L, solution.minimumMoney(arrayOf(intArrayOf(0, 5))))
    }

    @Test
    fun testSingleLoss() {
        assertEquals(7L, solution.minimumMoney(arrayOf(intArrayOf(7, 0))))
    }

    @Test
    fun testAllProfitable() {
        assertEquals(3L, solution.minimumMoney(
            arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        ))
    }

    @Test
    fun testLargeValues() {
        assertEquals(1000000000L, solution.minimumMoney(
            arrayOf(intArrayOf(1000000000, 0))
        ))
    }
}
