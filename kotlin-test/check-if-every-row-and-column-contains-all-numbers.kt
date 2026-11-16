package checkifeveryrowandcolumncontainsallnumbers

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfEveryRowAndColumnContainsAllNumbersTest {
    private val solution = Solution()

    @Test
    fun validMatrix() {
        assertTrue(solution.checkValid(arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(3, 1, 2),
            intArrayOf(2, 3, 1)
        )))
    }

    @Test
    fun duplicateInRow() {
        assertFalse(solution.checkValid(arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2)
        )))
    }

    @Test
    fun duplicateInColumn() {
        assertFalse(solution.checkValid(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 2)
        )))
    }

    @Test
    fun singleElement() {
        assertTrue(solution.checkValid(arrayOf(intArrayOf(1))))
    }
}
