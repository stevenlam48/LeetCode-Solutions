package findthemedianoftheuniquenessarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMedianOfTheUniquenessArrayTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().medianOfUniquenessArray(intArrayOf(1, 2, 3)))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().medianOfUniquenessArray(intArrayOf(3, 4, 3, 4)))
    }

    @Test
    fun example3() {
        assertEquals(2, Solution().medianOfUniquenessArray(intArrayOf(4, 3, 5, 4)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().medianOfUniquenessArray(intArrayOf(1)))
    }
}
