package countelementswithatleastkgreatervalues

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountElementsWithAtLeastKGreaterValuesTest {
    @Test
    fun example() {
        assertEquals(2, Solution().countElements(intArrayOf(5, 2, 3, 1, 4), 3))
    }

    @Test
    fun zeroGreaterNeeded() {
        assertEquals(5, Solution().countElements(intArrayOf(5, 2, 3, 1, 4), 0))
    }

    @Test
    fun allGreaterNeeded() {
        assertEquals(0, Solution().countElements(intArrayOf(5, 2, 3, 1, 4), 5))
    }

    @Test
    fun duplicates() {
        assertEquals(0, Solution().countElements(intArrayOf(1, 1, 1), 2))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().countElements(intArrayOf(7), 1))
        assertEquals(1, Solution().countElements(intArrayOf(7), 0))
    }

    @Test
    fun sortedDistinct() {
        assertEquals(0, Solution().countElements(intArrayOf(1, 2, 3, 4), 4))
        assertEquals(3, Solution().countElements(intArrayOf(1, 2, 3, 4), 1))
    }
}
