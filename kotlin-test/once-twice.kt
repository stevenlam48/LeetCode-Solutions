package oncetwice

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OnceTwiceTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(1, 2), solution.onceTwice(intArrayOf(1, 2, 2, 3, 3, 3)))
    }

    @Test
    fun testExample2() {
        assertArrayEquals(intArrayOf(9, 7), solution.onceTwice(intArrayOf(5, 5, 5, 7, 7, 9)))
    }

    @Test
    fun testLarger() {
        assertArrayEquals(
            intArrayOf(5, 1),
            solution.onceTwice(intArrayOf(1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5))
        )
    }

    @Test
    fun testNegative() {
        assertArrayEquals(intArrayOf(-3, -5), solution.onceTwice(intArrayOf(-5, -5, 7, 7, 7, -3)))
    }
}
