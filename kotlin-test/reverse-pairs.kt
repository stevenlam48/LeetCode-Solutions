package reversepairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReversePairsTest {
    @Test
    fun exampleOne() {
        assertEquals(2, Solution().reversePairs(intArrayOf(1, 3, 2, 3, 1)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(3, Solution().reversePairs(intArrayOf(2, 4, 3, 5, 1)))
    }

    @Test
    fun strictInequalityAndDuplicates() {
        assertEquals(0, Solution().reversePairs(intArrayOf(2, 1, 2, 1)))
    }

    @Test
    fun largeValuesDoNotOverflow() {
        assertEquals(2, Solution().reversePairs(intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, -1)))
    }

    @Test
    fun emptyAndSingleElement() {
        assertEquals(0, Solution().reversePairs(intArrayOf()))
        assertEquals(0, Solution().reversePairs(intArrayOf(1)))
    }
}
