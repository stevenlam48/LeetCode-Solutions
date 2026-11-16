package formlargestintegerwithdigitsthatadduptotarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FormLargestIntegerWithDigitsThatAddUpToTargetTest {
    private val solution = Solution()

    @Test
    fun `four digits with three sevens`() {
        val cost = intArrayOf(4, 3, 2, 5, 6, 7, 2, 5, 5)

        assertEquals("7772", solution.largestNumber(cost, 9))
    }

    @Test
    fun `fewer larger digits beat more digits only when length is maximal`() {
        val cost = intArrayOf(7, 6, 5, 5, 5, 6, 8, 7, 8)

        assertEquals("85", solution.largestNumber(cost, 12))
    }

    @Test
    fun `unreachable target returns zero`() {
        val cost = intArrayOf(2, 4, 6, 2, 4, 6, 4, 4, 4)

        assertEquals("0", solution.largestNumber(cost, 5))
    }

    @Test
    fun `maximum length includes repeated small digits`() {
        val cost = intArrayOf(6, 10, 15, 40, 40, 40, 40, 40, 40)

        assertEquals("32211", solution.largestNumber(cost, 47))
    }
}
