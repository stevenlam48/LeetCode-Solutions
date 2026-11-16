package countspecialtriplets

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSpecialTripletsTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(1, solution.specialTriplets(intArrayOf(6, 3, 6)))
    }

    @Test
    fun zeros() {
        assertEquals(1, solution.specialTriplets(intArrayOf(0, 1, 0, 0)))
    }

    @Test
    fun allZeros() {
        assertEquals(1, solution.specialTriplets(intArrayOf(0, 0, 0)))
    }

    @Test
    fun noTriplet() {
        assertEquals(0, solution.specialTriplets(intArrayOf(1, 1, 1)))
    }
}
