package sumofkmirrornumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfKMirrorNumbersTest {
    private val solution = Solution()

    @Test
    fun baseTwoExample() {
        assertEquals(25L, solution.kMirror(2, 5))
    }

    @Test
    fun baseThreeExample() {
        assertEquals(499L, solution.kMirror(3, 7))
    }

    @Test
    fun firstNumber() {
        assertEquals(1L, solution.kMirror(2, 1))
    }

    @Test
    fun decimalBase() {
        assertEquals(6L, solution.kMirror(10, 3))
    }
}
