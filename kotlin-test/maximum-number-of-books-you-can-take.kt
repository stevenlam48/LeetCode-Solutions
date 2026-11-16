package maximumnumberofbooksyoucantake

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfBooksYouCanTakeTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(19L, solution.maximumBooks(intArrayOf(8, 5, 2, 7, 9)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(13L, solution.maximumBooks(intArrayOf(8, 2, 3, 7, 3, 4, 0, 1, 4, 3)))
    }

    @Test
    fun increasingSequence() {
        assertEquals(6L, solution.maximumBooks(intArrayOf(1, 2, 3)))
    }

    @Test
    fun singleShelf() {
        assertEquals(5L, solution.maximumBooks(intArrayOf(5)))
    }

    @Test
    fun allZero() {
        assertEquals(0L, solution.maximumBooks(intArrayOf(0, 0, 0)))
    }

    @Test
    fun equalValues() {
        assertEquals(3L, solution.maximumBooks(intArrayOf(2, 2, 2)))
    }
}
