package numberofarithmetictriplets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfArithmeticTripletsTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().arithmeticTriplets(intArrayOf(0, 1, 4, 6, 7, 10), 3))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().arithmeticTriplets(intArrayOf(4, 5, 6, 7, 8, 9), 2))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().arithmeticTriplets(intArrayOf(1), 1))
    }

    @Test
    fun consecutiveTriplet() {
        assertEquals(1, Solution().arithmeticTriplets(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun noTriplet() {
        assertEquals(0, Solution().arithmeticTriplets(intArrayOf(1, 5, 9), 2))
    }
}
