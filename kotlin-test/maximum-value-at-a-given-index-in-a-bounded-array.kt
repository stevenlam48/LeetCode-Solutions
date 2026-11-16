package maximumvalueatagivenindexinaboundedarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumValueAtAGivenIndexInABoundedArrayTest {
    @Test
    fun examples() {
        assertEquals(2, Solution().maxValue(4, 2, 6))
        assertEquals(3, Solution().maxValue(6, 1, 10))
    }

    @Test
    fun singleElement() {
        assertEquals(10, Solution().maxValue(1, 0, 10))
    }

    @Test
    fun minimumAndLargeSums() {
        assertEquals(1, Solution().maxValue(4, 2, 4))
        assertEquals(26, Solution().maxValue(4, 2, 100))
    }
}
