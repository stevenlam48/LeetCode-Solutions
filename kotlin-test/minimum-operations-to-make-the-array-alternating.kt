package minimumoperationstomakethearrayalternating

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeTheArrayAlternatingTest {
    @Test
    fun example() {
        assertEquals(3, Solution().minimumOperations(intArrayOf(3, 1, 3, 2, 4, 3)))
    }

    @Test
    fun allDistinct() {
        assertEquals(3, Solution().minimumOperations(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun allEqual() {
        assertEquals(2, Solution().minimumOperations(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().minimumOperations(intArrayOf(1)))
    }
}
