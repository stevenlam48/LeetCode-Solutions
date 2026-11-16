package minimumnumberofoperationstomakeelementsinarraydistinct

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToMakeElementsInArrayDistinctTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(
            2,
            solution.minimumOperations(intArrayOf(1, 2, 3, 4, 2, 3, 3, 5, 7))
        )
    }

    @Test
    fun duplicateInLastThree() {
        assertEquals(2, solution.minimumOperations(intArrayOf(4, 5, 6, 4, 4)))
    }

    @Test
    fun allDistinct() {
        assertEquals(0, solution.minimumOperations(intArrayOf(6, 7, 8, 9)))
    }

    @Test
    fun duplicateOfLastElement() {
        assertEquals(2, solution.minimumOperations(intArrayOf(1, 2, 3, 4, 4)))
    }
}
