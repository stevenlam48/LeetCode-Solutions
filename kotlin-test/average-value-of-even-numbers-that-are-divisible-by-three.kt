package averagevalueofevennumbersthataredivisiblebythree

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AverageValueOfEvenNumbersThatAreDivisibleByThreeTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(9, solution.averageValue(intArrayOf(1, 3, 6, 10, 12, 15)))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.averageValue(intArrayOf(1, 2, 4, 7, 10)))
    }

    @Test
    fun testZeroAndNegatives() {
        assertEquals(0, solution.averageValue(intArrayOf(0)))
        assertEquals(0, solution.averageValue(intArrayOf(-6, 6)))
    }

    @Test
    fun testTruncation() {
        assertEquals(13, solution.averageValue(intArrayOf(6, 12, 18, 18)))
    }
}
