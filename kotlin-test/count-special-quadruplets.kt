package countspecialquadruplets

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSpecialQuadrupletsTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(1, solution.countQuadruplets(intArrayOf(1, 2, 3, 6)))
    }

    @Test
    fun example2() {
        assertEquals(4, solution.countQuadruplets(intArrayOf(1, 1, 1, 3, 5)))
    }

    @Test
    fun tooShort() {
        assertEquals(0, solution.countQuadruplets(intArrayOf(1, 2, 3)))
    }

    @Test
    fun allEqual() {
        assertEquals(0, solution.countQuadruplets(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun exactSum() {
        assertEquals(1, solution.countQuadruplets(intArrayOf(2, 2, 2, 6)))
    }
}
