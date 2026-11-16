package checkifnanditsdoubleexist

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfNAndItsDoubleExistTest {
    private val solution = Solution()

    @Test
    fun laterValueIsDouble() {
        assertTrue(solution.checkIfExist(intArrayOf(10, 2, 5, 3)))
    }

    @Test
    fun earlierValueIsDouble() {
        assertTrue(solution.checkIfExist(intArrayOf(7, 1, 14, 11)))
    }

    @Test
    fun noDoubleExists() {
        assertFalse(solution.checkIfExist(intArrayOf(3, 1, 7, 11)))
    }

    @Test
    fun negativeValues() {
        assertTrue(solution.checkIfExist(intArrayOf(-10, 12, -20, -8, 15)))
    }

    @Test
    fun singleZeroIsNotItsOwnPair() {
        assertFalse(solution.checkIfExist(intArrayOf(0)))
    }

    @Test
    fun twoZerosFormPair() {
        assertTrue(solution.checkIfExist(intArrayOf(0, 0)))
    }
}
