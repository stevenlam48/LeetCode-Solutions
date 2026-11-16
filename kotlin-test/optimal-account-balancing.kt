package optimalaccountbalancing

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OptimalAccountBalancingTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            2,
            solution.minTransfers(arrayOf(intArrayOf(0, 1, 10), intArrayOf(2, 0, 5)))
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            1,
            solution.minTransfers(
                arrayOf(
                    intArrayOf(0, 1, 10),
                    intArrayOf(1, 0, 1),
                    intArrayOf(1, 2, 5),
                    intArrayOf(2, 0, 5)
                )
            )
        )
    }

    @Test
    fun testSingleTransaction() {
        assertEquals(1, solution.minTransfers(arrayOf(intArrayOf(0, 1, 5))))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, solution.minTransfers(emptyArray()))
    }
}
