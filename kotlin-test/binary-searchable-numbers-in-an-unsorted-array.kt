package binarysearchablenumbersinanunsortedarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinarySearchableNumbersInAnUnsortedArrayTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().binarySearchableNumbers(intArrayOf(2, 1, 3)))
    }

    @Test
    fun sortedAscending() {
        assertEquals(6, Solution().binarySearchableNumbers(intArrayOf(0, 1, 2, 3, 4, 5)))
    }

    @Test
    fun sortedDescending() {
        assertEquals(0, Solution().binarySearchableNumbers(intArrayOf(3, 2, 1)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().binarySearchableNumbers(intArrayOf(5)))
    }

    @Test
    fun duplicatesCountedOnce() {
        assertEquals(1, Solution().binarySearchableNumbers(intArrayOf(1, 1, 1)))
    }

    @Test
    fun mixedWithNegatives() {
        assertEquals(1, Solution().binarySearchableNumbers(intArrayOf(-1, 5, 2)))
    }
}
