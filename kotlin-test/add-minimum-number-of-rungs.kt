package addminimumnumberofrungs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddMinimumNumberOfRungsTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(2, solution.addRungs(intArrayOf(1, 3, 5, 10), 2))
    }

    @Test
    fun secondExample() {
        assertEquals(0, solution.addRungs(intArrayOf(3, 6, 8, 10), 4))
    }

    @Test
    fun thirdExample() {
        assertEquals(3, solution.addRungs(intArrayOf(3, 4, 6, 7), 1))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, solution.addRungs(intArrayOf(), 3))
    }

    @Test
    fun initialGap() {
        assertEquals(4, solution.addRungs(intArrayOf(10), 2))
    }
}
