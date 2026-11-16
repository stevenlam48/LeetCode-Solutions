package smallestnumberwithallsetbits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestNumberWithAllSetBitsTest {
    private val solution = Solution()

    @Test
    fun powersOfTwoAndZero() {
        assertEquals(0, solution.smallestNumber(0))
        assertEquals(1, solution.smallestNumber(1))
        assertEquals(3, solution.smallestNumber(2))
        assertEquals(7, solution.smallestNumber(4))
    }

    @Test
    fun valuesBetweenPowersOfTwo() {
        assertEquals(7, solution.smallestNumber(5))
        assertEquals(15, solution.smallestNumber(10))
        assertEquals(1023, solution.smallestNumber(1000))
    }

    @Test
    fun valuesWithAllBitsAlreadySet() {
        assertEquals(3, solution.smallestNumber(3))
        assertEquals(31, solution.smallestNumber(31))
        assertEquals(255, solution.smallestNumber(255))
    }
}
