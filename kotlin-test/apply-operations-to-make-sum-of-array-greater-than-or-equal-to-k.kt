package applyoperationstomakesumofarraygreaterthanorequaltok

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToKTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(5, solution.minOperations(11))
    }

    @Test
    fun alreadyMeetsTarget() {
        assertEquals(0, solution.minOperations(1))
    }

    @Test
    fun smallestNontrivialTarget() {
        assertEquals(1, solution.minOperations(2))
    }

    @Test
    fun perfectSquare() {
        assertEquals(4, solution.minOperations(9))
    }
}
