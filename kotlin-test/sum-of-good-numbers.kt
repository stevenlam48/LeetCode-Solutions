package sumofgoodnumbers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfGoodNumbersTest {
    @Test
    fun kEqualsOne() {
        assertEquals(8, Solution().sumOfGoodNumbers(intArrayOf(1, 3, 2, 5, 4), 1))
    }

    @Test
    fun twoElements() {
        assertEquals(2, Solution().sumOfGoodNumbers(intArrayOf(2, 1), 1))
    }

    @Test
    fun largerK() {
        assertEquals(9, Solution().sumOfGoodNumbers(intArrayOf(1, 2, 3, 4, 5), 2))
    }
}
