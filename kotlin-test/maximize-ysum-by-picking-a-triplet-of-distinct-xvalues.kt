package maximizeysumbypickingatripletofdistinctxvalues

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeYsumByPickingATripletOfDistinctXvaluesTest {
    @Test
    fun exampleOne() {
        assertEquals(
            14,
            Solution().maxSumDistinctTriplet(
                intArrayOf(1, 2, 1, 3, 2),
                intArrayOf(5, 3, 4, 6, 2)
            )
        )
    }

    @Test
    fun fewerThanThreeDistinct() {
        assertEquals(
            -1,
            Solution().maxSumDistinctTriplet(
                intArrayOf(1, 2, 1, 2),
                intArrayOf(4, 5, 6, 7)
            )
        )
    }

    @Test
    fun distinctValues() {
        assertEquals(
            6,
            Solution().maxSumDistinctTriplet(
                intArrayOf(1, 2, 3),
                intArrayOf(1, 2, 3)
            )
        )
    }

    @Test
    fun singleDistinct() {
        assertEquals(
            -1,
            Solution().maxSumDistinctTriplet(
                intArrayOf(1, 1, 1),
                intArrayOf(5, 5, 5)
            )
        )
    }
}
