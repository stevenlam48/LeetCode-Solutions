package gcdsortofanarray

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GcdSortOfAnArrayTest {
    @Test
    fun example1() {
        assertTrue(Solution().gcdSort(intArrayOf(7, 21, 3)))
    }

    @Test
    fun example2() {
        assertFalse(Solution().gcdSort(intArrayOf(5, 2, 6, 2)))
    }

    @Test
    fun example3() {
        assertTrue(Solution().gcdSort(intArrayOf(10, 5, 2, 8)))
    }

    @Test
    fun singleElement() {
        assertTrue(Solution().gcdSort(intArrayOf(7)))
    }

    @Test
    fun equalElements() {
        assertTrue(Solution().gcdSort(intArrayOf(1, 1, 1)))
    }

    @Test
    fun coprimeCannotMove() {
        assertFalse(Solution().gcdSort(intArrayOf(3, 1, 2)))
    }
}
