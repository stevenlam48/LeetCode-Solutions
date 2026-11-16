package maximumnumberofoperationstomoveonestotheend

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfOperationsToMoveOnesToTheEndTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(4, solution.maxOperations("1001101"))
    }

    @Test
    fun standardExampleWithNoMoves() {
        assertEquals(0, solution.maxOperations("00111"))
    }

    @Test
    fun allZeros() {
        assertEquals(0, solution.maxOperations("0000"))
    }

    @Test
    fun allOnes() {
        assertEquals(0, solution.maxOperations("111"))
    }

    @Test
    fun alternatingBits() {
        assertEquals(1, solution.maxOperations("0101"))
        assertEquals(3, solution.maxOperations("1010"))
    }
}
