package numberofdistinctbinarystringsafterapplyingoperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfDistinctBinaryStringsAfterApplyingOperationsTest {
    @Test
    fun example1() {
        assertEquals(4, Solution().countDistinctStrings("1001", 3))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().countDistinctStrings("10110", 5))
    }

    @Test
    fun singleCharacter() {
        assertEquals(2, Solution().countDistinctStrings("0", 1))
    }

    @Test
    fun everyBitCanVary() {
        assertEquals(16, Solution().countDistinctStrings("1111", 1))
    }

    @Test
    fun longerInput() {
        assertEquals(128, Solution().countDistinctStrings("0101010101", 4))
    }

    @Test
    fun appliesModulus() {
        assertEquals(73_741_817, Solution().countDistinctStrings("0".repeat(30), 1))
    }
}
