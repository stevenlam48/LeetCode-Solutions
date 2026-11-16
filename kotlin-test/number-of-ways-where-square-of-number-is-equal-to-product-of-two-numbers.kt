package numberofwayswheresquareofnumberisequaltoproductoftwonumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbersTest {
    @Test
    fun firstExample() {
        assertEquals(1, Solution().numTriplets(intArrayOf(7, 4), intArrayOf(5, 2, 8, 9)))
    }

    @Test
    fun duplicateOnes() {
        assertEquals(9, Solution().numTriplets(intArrayOf(1, 1), intArrayOf(1, 1, 1)))
    }

    @Test
    fun secondExample() {
        assertEquals(2, Solution().numTriplets(intArrayOf(7, 7, 8, 3), intArrayOf(1, 2, 9, 7)))
    }

    @Test
    fun noProducts() {
        assertEquals(0, Solution().numTriplets(intArrayOf(2), intArrayOf(3, 5)))
    }
}
