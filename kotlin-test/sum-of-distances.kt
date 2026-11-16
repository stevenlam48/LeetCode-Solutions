package sumofdistances

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfDistancesTest {
    @Test
    fun exampleOne() {
        assertArrayEquals(
            longArrayOf(5, 0, 3, 4, 0),
            Solution().distance(intArrayOf(1, 3, 1, 1, 2))
        )
    }

    @Test
    fun singleElement() {
        assertArrayEquals(longArrayOf(0), Solution().distance(intArrayOf(10)))
    }

    @Test
    fun repeatedValues() {
        assertArrayEquals(longArrayOf(3, 2, 3), Solution().distance(intArrayOf(1, 1, 1)))
    }
}
