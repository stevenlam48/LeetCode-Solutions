package removeoneelementtomakethearraystrictlyincreasing

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RemoveOneElementToMakeTheArrayStrictlyIncreasingTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.canBeIncreasing(intArrayOf(1, 2, 10, 5, 7)))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.canBeIncreasing(intArrayOf(2, 3, 1, 2)))
    }

    @Test
    fun testExample3() {
        assertFalse(solution.canBeIncreasing(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testAlreadyIncreasing() {
        assertTrue(solution.canBeIncreasing(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testSingleElement() {
        assertTrue(solution.canBeIncreasing(intArrayOf(1)))
    }

    @Test
    fun testDuplicateAtEnd() {
        assertTrue(solution.canBeIncreasing(intArrayOf(1, 2, 2)))
    }
}
