package sumofabsolutedifferencesinasortedarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfAbsoluteDifferencesInASortedArrayTest {
    @Test
    fun exampleOne() {
        assertArrayEquals(
            intArrayOf(4, 3, 5),
            Solution().getSumAbsoluteDifferences(intArrayOf(2, 3, 5))
        )
    }

    @Test
    fun exampleTwo() {
        assertArrayEquals(
            intArrayOf(24, 15, 13, 15, 21),
            Solution().getSumAbsoluteDifferences(intArrayOf(1, 4, 6, 8, 10))
        )
    }

    @Test
    fun negativeAndDuplicateValues() {
        assertArrayEquals(
            intArrayOf(6, 3, 3),
            Solution().getSumAbsoluteDifferences(intArrayOf(-2, 1, 1))
        )
    }

    @Test
    fun singletonAndEmptyInput() {
        assertArrayEquals(intArrayOf(0), Solution().getSumAbsoluteDifferences(intArrayOf(7)))
        assertArrayEquals(intArrayOf(), Solution().getSumAbsoluteDifferences(intArrayOf()))
    }

    @Test
    fun duplicatesDoNotContribute() {
        assertArrayEquals(intArrayOf(0, 0, 0), Solution().getSumAbsoluteDifferences(intArrayOf(4, 4, 4)))
    }
}
