package arraytransformation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ArrayTransformationTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(6, 3, 3, 4), solution.transformArray(intArrayOf(6, 2, 3, 4)))
    }

    @Test
    fun testExample2() {
        assertArrayEquals(
            intArrayOf(1, 4, 4, 4, 4, 5),
            solution.transformArray(intArrayOf(1, 6, 3, 4, 3, 5))
        )
    }

    @Test
    fun testStable() {
        assertArrayEquals(intArrayOf(1, 2, 3), solution.transformArray(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testSmall() {
        assertArrayEquals(intArrayOf(5), solution.transformArray(intArrayOf(5)))
        assertArrayEquals(intArrayOf(2, 1), solution.transformArray(intArrayOf(2, 1)))
    }
}
