package findluckyintegerinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindLuckyIntegerInAnArrayTest {
    @Test
    fun findsValueWhoseFrequencyEqualsItself() {
        assertEquals(2, Solution().findLucky(intArrayOf(2, 2, 3, 4)))
    }

    @Test
    fun returnsLargestLuckyInteger() {
        assertEquals(3, Solution().findLucky(intArrayOf(1, 2, 2, 3, 3, 3)))
        assertEquals(3, Solution().findLucky(intArrayOf(2, 2, 3, 3, 3)))
    }

    @Test
    fun returnsMinusOneWhenNoLuckyIntegerExists() {
        assertEquals(-1, Solution().findLucky(intArrayOf(5)))
        assertEquals(-1, Solution().findLucky(intArrayOf()))
    }
}
