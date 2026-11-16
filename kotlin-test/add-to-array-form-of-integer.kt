package addtoarrayformofinteger

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class AddToArrayFormOfIntegerTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertArrayEquals(intArrayOf(1, 2, 3, 4), solution.addToArrayForm(intArrayOf(1, 2, 0, 0), 34))
    }

    @Test
    fun secondExample() {
        assertArrayEquals(intArrayOf(4, 5, 5), solution.addToArrayForm(intArrayOf(2, 7, 4), 181))
    }

    @Test
    fun thirdExample() {
        assertArrayEquals(intArrayOf(1, 0, 2, 1), solution.addToArrayForm(intArrayOf(2, 1, 5), 806))
    }

    @Test
    fun carryExtendsArray() {
        assertArrayEquals(intArrayOf(1, 0, 0, 0), solution.addToArrayForm(intArrayOf(9, 9, 9), 1))
    }

    @Test
    fun zeroAdded() {
        assertArrayEquals(intArrayOf(0), solution.addToArrayForm(intArrayOf(0), 0))
    }
}
