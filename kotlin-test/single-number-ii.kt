package singlenumberii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SingleNumberIiTest {
    private val solution = Solution()

    @Test
    fun `one value appears once`() {
        assertEquals(3, solution.singleNumber(intArrayOf(2, 2, 3, 2)))
    }

    @Test
    fun `larger unpaired value`() {
        assertEquals(99, solution.singleNumber(intArrayOf(0, 1, 0, 1, 0, 1, 99)))
    }

    @Test
    fun `negative unpaired value`() {
        assertEquals(-5, solution.singleNumber(intArrayOf(-2, -2, -2, -5)))
    }

    @Test
    fun `single input value`() {
        assertEquals(7, solution.singleNumber(intArrayOf(7)))
    }
}
