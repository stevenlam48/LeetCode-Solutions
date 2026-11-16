package countgoodtriplets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountGoodTripletsTest {
    private val solution = Solution()

    @Test
    fun countsFirstExample() {
        assertEquals(4, solution.countGoodTriplets(intArrayOf(3, 0, 1, 1, 9, 7), 7, 2, 3))
    }

    @Test
    fun countsSecondExample() {
        assertEquals(0, solution.countGoodTriplets(intArrayOf(1, 1, 2, 2, 3), 0, 0, 1))
    }

    @Test
    fun fewerThanThreeElementsCannotFormTriplet() {
        assertEquals(0, solution.countGoodTriplets(intArrayOf(1, 2), 10, 10, 10))
    }
}
