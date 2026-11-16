package findthemaximumnumberofmarkedindices

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMaximumNumberOfMarkedIndicesTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().maxNumOfMarkedIndices(intArrayOf(3, 5, 2, 4)))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().maxNumOfMarkedIndices(intArrayOf(9, 2, 5, 4)))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().maxNumOfMarkedIndices(intArrayOf(7, 6, 8)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().maxNumOfMarkedIndices(intArrayOf(1)))
    }
}
