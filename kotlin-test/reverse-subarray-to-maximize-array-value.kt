package reversesubarraytomaximizearrayvalue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseSubarrayToMaximizeArrayValueTest {
    @Test
    fun exampleOne() {
        assertEquals(10, Solution().maxValueAfterReverse(intArrayOf(2, 3, 1, 5, 4)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(68, Solution().maxValueAfterReverse(intArrayOf(2, 4, 9, 24, 2, 1, 10)))
    }

    @Test
    fun increasingArrayUsesInternalReversal() {
        assertEquals(8, Solution().maxValueAfterReverse(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun equalValues() {
        assertEquals(0, Solution().maxValueAfterReverse(intArrayOf(7, 7, 7)))
    }
}
