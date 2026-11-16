package reachanumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ReachANumberTest {
    @Test
    fun leetCodeExamples() {
        assertEquals(3, Solution().reachNumber(2))
        assertEquals(2, Solution().reachNumber(3))
    }

    @Test
    fun negativeTargetsMatchPositiveOnes() {
        for (target in intArrayOf(1, 2, 4, 5, 6, 7, 12)) {
            assertEquals(Solution().reachNumber(target), Solution().reachNumber(-target))
        }
        assertEquals(3, Solution().reachNumber(-4))
        assertEquals(5, Solution().reachNumber(-5))
    }

    @Test
    fun zeroAndTriangularTargets() {
        assertEquals(0, Solution().reachNumber(0))
        assertEquals(1, Solution().reachNumber(1))
        assertEquals(4, Solution().reachNumber(10))
        assertEquals(5, Solution().reachNumber(15))
    }
}
