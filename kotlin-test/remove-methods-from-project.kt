package removemethodsfromproject

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RemoveMethodsFromProjectTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val invocations = arrayOf(intArrayOf(1, 2), intArrayOf(0, 1), intArrayOf(3, 2))
        assertArrayEquals(intArrayOf(0, 1, 2, 3), solution.remainingMethods(4, 1, invocations))
    }

    @Test
    fun testExample2() {
        val invocations = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(0, 2),
            intArrayOf(0, 1),
            intArrayOf(3, 4)
        )
        assertArrayEquals(intArrayOf(3, 4), solution.remainingMethods(5, 0, invocations))
    }

    @Test
    fun testAllMethodsRemoved() {
        val invocations = arrayOf(intArrayOf(1, 2), intArrayOf(0, 1), intArrayOf(2, 0))
        assertArrayEquals(intArrayOf(), solution.remainingMethods(3, 2, invocations))
    }

    @Test
    fun testNoInvocations() {
        assertArrayEquals(intArrayOf(0, 2), solution.remainingMethods(3, 1, arrayOf()))
    }
}
