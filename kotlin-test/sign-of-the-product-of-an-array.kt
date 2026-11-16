package signoftheproductofanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SignOfTheProductOfAnArrayTest {
    private val solution = Solution()

    @Test
    fun `positive product`() {
        assertEquals(1, solution.arraySign(intArrayOf(-1, -2, -3, -4, 3, 2, 1)))
    }

    @Test
    fun `negative product`() {
        assertEquals(-1, solution.arraySign(intArrayOf(-1, 28)))
    }

    @Test
    fun `zero product`() {
        assertEquals(0, solution.arraySign(intArrayOf(1, 5, 0, 2, -3)))
    }

    @Test
    fun `empty and odd negative count`() {
        assertEquals(1, solution.arraySign(intArrayOf()))
        assertEquals(-1, solution.arraySign(intArrayOf(-1, 2, 3)))
    }
}
