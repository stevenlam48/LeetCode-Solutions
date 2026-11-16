package invalidtransactions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InvalidTransactionsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val result = solution.invalidTransactions(
            arrayOf("alice,20,800,mtv", "alice,50,100,beijing")
        )
        assertEquals(
            listOf("alice,20,800,mtv", "alice,50,100,beijing").sorted(),
            result.sorted()
        )
    }

    @Test
    fun testExample2() {
        val result = solution.invalidTransactions(
            arrayOf("alice,20,800,mtv", "alice,50,1200,mtv")
        )
        assertEquals(listOf("alice,50,1200,mtv"), result)
    }

    @Test
    fun testExample3() {
        val result = solution.invalidTransactions(
            arrayOf("alice,20,800,mtv", "bob,50,1200,mtv")
        )
        assertEquals(listOf("bob,50,1200,mtv"), result)
    }

    @Test
    fun testSameCityWithinWindowIsValid() {
        val result = solution.invalidTransactions(
            arrayOf("alice,20,800,mtv", "alice,30,900,mtv")
        )
        assertTrue(result.isEmpty())
    }

    @Test
    fun testWindowBoundary() {
        val result = solution.invalidTransactions(
            arrayOf("alice,20,800,mtv", "alice,80,800,beijing")
        )
        assertEquals(
            listOf("alice,20,800,mtv", "alice,80,800,beijing").sorted(),
            result.sorted()
        )
    }

    @Test
    fun testOutsideWindow() {
        val result = solution.invalidTransactions(
            arrayOf("alice,20,800,mtv", "alice,81,800,beijing")
        )
        assertTrue(result.isEmpty())
    }
}
