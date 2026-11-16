package minimumnonzeroproductofthearrayelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNonZeroProductOfTheArrayElementsTest {
    private val solution = Solution()

    @Test
    fun singleElementArray() {
        assertEquals(1, solution.minNonZeroProduct(1))
    }

    @Test
    fun threeElementArray() {
        assertEquals(6, solution.minNonZeroProduct(2))
    }

    @Test
    fun sevenElementArray() {
        assertEquals(1512, solution.minNonZeroProduct(3))
    }

    @Test
    fun fifteenElementArray() {
        assertEquals(581202553, solution.minNonZeroProduct(4))
    }
}
