package secondminimumtimetoreachdestination

// Time:  O(|V| + |E|) = O(|E|) since graph is connected, O(|E|) >= O(|V|)
// Space: O(|V| + |E|) = O(|E|)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SecondMinimumTimeToReachDestinationTest {
    @Test
    fun firstExample() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 4),
            intArrayOf(3, 4),
            intArrayOf(4, 5)
        )
        assertEquals(13, Solution().secondMinimum(5, edges, 3, 5))
    }

    @Test
    fun secondExample() {
        assertEquals(11, Solution().secondMinimum(2, arrayOf(intArrayOf(1, 2)), 3, 2))
    }

    @Test
    fun directAndAlternateRoutes() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(1, 3))
        assertEquals(2, Solution().secondMinimum(3, edges, 1, 10))
    }

    @Test
    fun waitsAtSuccessiveSignals() {
        assertEquals(5, Solution().secondMinimum(2, arrayOf(intArrayOf(1, 2)), 1, 2))
    }
}
