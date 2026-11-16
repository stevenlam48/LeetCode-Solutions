package dividearrayintoarrayswithmaxdifference

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DivideArrayIntoArraysWithMaxDifferenceTest {
    private val solution = Solution()

    @Test
    fun sortedTripletsSatisfyDifference() {
        assertArrayEquals(
            arrayOf(intArrayOf(1, 1, 3), intArrayOf(3, 4, 5), intArrayOf(7, 8, 9)),
            solution.divideArray(intArrayOf(1, 3, 4, 8, 7, 9, 3, 5, 1), 2)
        )
    }

    @Test
    fun oneTripletExceedsDifference() {
        assertArrayEquals(emptyArray(), solution.divideArray(intArrayOf(2, 4, 2, 2, 5, 2), 2))
    }

    @Test
    fun singleTriplet() {
        assertArrayEquals(arrayOf(intArrayOf(1, 2, 3)), solution.divideArray(intArrayOf(3, 1, 2), 2))
    }
}
