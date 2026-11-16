package minimumoperationstotransformbinarystring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToTransformBinaryStringTest {
    private val solution = Solution()

    @Test
    fun returnsZeroWhenStringsAlreadyMatch() {
        assertEquals(0, solution.minOperations("0000", "0000"))
    }

    @Test
    fun transformsEachZeroIndependently() {
        assertEquals(2, solution.minOperations("0011", "1111"))
    }

    @Test
    fun usesTheFollowingOne() {
        assertEquals(1, solution.minOperations("1100", "0000"))
    }

    @Test
    fun usesTheFollowingZero() {
        assertEquals(2, solution.minOperations("1000", "0000"))
    }

    @Test
    fun handlesOneAtTheLastPosition() {
        assertEquals(2, solution.minOperations("01", "00"))
    }

    @Test
    fun handlesImpossibleSingleCharacterTransformation() {
        assertEquals(-1, solution.minOperations("1", "0"))
    }
}
