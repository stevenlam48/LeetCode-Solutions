package meanofarrayafterremovingsomeelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MeanOfArrayAfterRemovingSomeElementsTest {
    @Test
    fun exampleOne() {
        val arr = intArrayOf(1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3)
        assertEquals(2.0, Solution().trimMean(arr), 1e-9)
    }

    @Test
    fun exampleTwo() {
        val arr = intArrayOf(6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0)
        assertEquals(4.0, Solution().trimMean(arr), 1e-9)
    }

    @Test
    fun equalNegativeValues() {
        assertEquals(-3.0, Solution().trimMean(IntArray(20) { -3 }), 1e-9)
    }
}
