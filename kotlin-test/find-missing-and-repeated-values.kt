package findmissingandrepeatedvalues

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindMissingAndRepeatedValuesTest {
    @Test
    fun example1() {
        val grid = arrayOf(intArrayOf(1, 3), intArrayOf(2, 2))
        assertArrayEquals(intArrayOf(2, 4), Solution().findMissingAndRepeatedValues(grid))
    }

    @Test
    fun example2() {
        val grid = arrayOf(
            intArrayOf(9, 1, 7),
            intArrayOf(8, 9, 2),
            intArrayOf(3, 4, 6)
        )
        assertArrayEquals(intArrayOf(9, 5), Solution().findMissingAndRepeatedValues(grid))
    }

    @Test
    fun repeatedOne() {
        val grid = arrayOf(intArrayOf(1, 1), intArrayOf(2, 3))
        assertArrayEquals(intArrayOf(1, 4), Solution().findMissingAndRepeatedValues(grid))
    }

    @Test
    fun repeatedMax() {
        val grid = arrayOf(intArrayOf(4, 2), intArrayOf(3, 4))
        assertArrayEquals(intArrayOf(4, 1), Solution().findMissingAndRepeatedValues(grid))
    }

    @Test
    fun repeatedTwo() {
        val grid = arrayOf(intArrayOf(2, 2), intArrayOf(3, 4))
        assertArrayEquals(intArrayOf(2, 1), Solution().findMissingAndRepeatedValues(grid))
    }

    @Test
    fun threeByThree() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 8)
        )
        assertArrayEquals(intArrayOf(8, 9), Solution().findMissingAndRepeatedValues(grid))
    }
}
