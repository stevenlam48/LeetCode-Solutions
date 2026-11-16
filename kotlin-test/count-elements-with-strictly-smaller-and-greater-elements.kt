package countelementswithstrictlysmallerandgreaterelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountElementsWithStrictlySmallerAndGreaterElementsTest {
    @Test
    fun example() {
        assertEquals(2, Solution().countElements(intArrayOf(11, 7, 2, 15)))
    }

    @Test
    fun twoElements() {
        assertEquals(0, Solution().countElements(intArrayOf(1, 2)))
    }

    @Test
    fun negativesAndDuplicates() {
        assertEquals(2, Solution().countElements(intArrayOf(-3, 3, 3, 90)))
    }

    @Test
    fun allEqual() {
        assertEquals(0, Solution().countElements(intArrayOf(1, 1, 1)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().countElements(intArrayOf(5)))
    }
}
