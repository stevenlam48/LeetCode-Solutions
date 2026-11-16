package setintersectionsizeatleasttwo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SetIntersectionSizeAtLeastTwoTest {
    @Test
    fun handlesSeparatedIntervals() {
        val intervals = arrayOf(intArrayOf(1, 3), intArrayOf(3, 7), intArrayOf(8, 9))
        assertEquals(5, Solution().intersectionSizeTwo(intervals))
    }

    @Test
    fun reusesPointsAcrossOverlappingIntervals() {
        val intervals = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(1, 4),
            intArrayOf(2, 5),
            intArrayOf(3, 5)
        )
        assertEquals(3, Solution().intersectionSizeTwo(intervals))
    }

    @Test
    fun handlesChainedAndSingleIntervals() {
        val chained = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(2, 4),
            intArrayOf(4, 5)
        )
        assertEquals(5, Solution().intersectionSizeTwo(chained))
        assertEquals(2, Solution().intersectionSizeTwo(arrayOf(intArrayOf(2, 4))))
    }
}
