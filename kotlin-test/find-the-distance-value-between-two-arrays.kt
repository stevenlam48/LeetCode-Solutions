package findthedistancevaluebetweentwoarrays

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheDistanceValueBetweenTwoArraysTest {
    @Test
    fun countsValuesOutsideDistanceThreshold() {
        assertEquals(2, Solution().findTheDistanceValue(intArrayOf(4, 5, 8), intArrayOf(10, 9, 1, 8), 2))
    }

    @Test
    fun handlesNegativeValues() {
        assertEquals(2, Solution().findTheDistanceValue(intArrayOf(1, 4, 2, 3), intArrayOf(-4, -3, 6, 10, 20, 30), 3))
    }

    @Test
    fun countsAllValuesWhenSecondArrayIsEmpty() {
        assertEquals(3, Solution().findTheDistanceValue(intArrayOf(1, 2, 3), intArrayOf(), 2))
    }

    @Test
    fun excludesValuesExactlyAtDistanceD() {
        assertEquals(0, Solution().findTheDistanceValue(intArrayOf(5), intArrayOf(3, 7), 2))
    }
}
