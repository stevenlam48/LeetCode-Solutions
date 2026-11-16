package makelexicographicallysmallestarraybyswappingelements

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MakeLexicographicallySmallestArrayBySwappingElementsTest {
    private fun check(expected: IntArray, actual: IntArray) {
        assertArrayEquals(expected, actual)
    }

    @Test
    fun testExample1() {
        check(
            intArrayOf(1, 3, 5, 8, 9),
            Solution().lexicographicallySmallestArray(intArrayOf(1, 5, 3, 9, 8), 2)
        )
    }

    @Test
    fun testExample2() {
        check(
            intArrayOf(1, 3, 5),
            Solution().lexicographicallySmallestArray(intArrayOf(5, 1, 3), 3)
        )
    }

    @Test
    fun testSingleElement() {
        check(intArrayOf(4), Solution().lexicographicallySmallestArray(intArrayOf(4), 10))
    }

    @Test
    fun testNoSwapsPossible() {
        check(
            intArrayOf(5, 1, 9),
            Solution().lexicographicallySmallestArray(intArrayOf(5, 1, 9), 0)
        )
    }

    @Test
    fun testDuplicates() {
        check(
            intArrayOf(2, 2, 3, 3),
            Solution().lexicographicallySmallestArray(intArrayOf(3, 2, 2, 3), 1)
        )
    }
}
