package applyoperationstomaketwostringsequal

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ApplyOperationsToMakeTwoStringsEqualTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(4, solution.minOperations("1100011000", "0101001010", 2))
    }

    @Test
    fun oddNumberOfDifferencesIsImpossible() {
        assertEquals(-1, solution.minOperations("10110", "00011", 4))
    }

    @Test
    fun expensiveOperationFavorsDistanceCost() {
        assertEquals(1, solution.minOperations("10", "01", 100))
    }

    @Test
    fun equalStringsNeedNoOperations() {
        assertEquals(0, solution.minOperations("00101", "00101", 3))
    }
}
