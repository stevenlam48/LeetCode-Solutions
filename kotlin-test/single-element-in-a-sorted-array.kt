package singleelementinasortedarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SingleElementInASortedArrayTest {
    private val solution = Solution()

    @Test
    fun `single element in middle`() {
        assertEquals(2, solution.singleNonDuplicate(intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8)))
    }

    @Test
    fun `single element after initial pairs`() {
        assertEquals(10, solution.singleNonDuplicate(intArrayOf(3, 3, 7, 7, 10, 11, 11)))
    }

    @Test
    fun `one element array`() {
        assertEquals(5, solution.singleNonDuplicate(intArrayOf(5)))
    }

    @Test
    fun `single element at beginning and end`() {
        assertEquals(1, solution.singleNonDuplicate(intArrayOf(1, 2, 2, 3, 3)))
        assertEquals(3, solution.singleNonDuplicate(intArrayOf(1, 1, 2, 2, 3)))
    }
}
