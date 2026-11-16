package mostexpensiveitemthatcannotbebought

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MostExpensiveItemThatCanNotBeBoughtTest {
    private val solution = Solution()

    @Test
    fun handlesSmallestPrimes() {
        assertEquals(1, solution.mostExpensiveItem(2, 3))
    }

    @Test
    fun handlesLargerPrimes() {
        assertEquals(23, solution.mostExpensiveItem(5, 7))
    }

    @Test
    fun handlesEvenPrimeWithFive() {
        assertEquals(3, solution.mostExpensiveItem(2, 5))
    }

    @Test
    fun isIndependentOfArgumentOrder() {
        assertEquals(7, solution.mostExpensiveItem(5, 3))
    }
}
