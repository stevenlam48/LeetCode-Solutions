package minimumoperationstosortastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToSortAStringTest {
    @Test
    fun alreadySorted() {
        assertEquals(0, Solution().minOperations("abc"))
        assertEquals(0, Solution().minOperations("a"))
    }

    @Test
    fun lengthTwoUnsorted() {
        assertEquals(-1, Solution().minOperations("ba"))
    }

    @Test
    fun oneOrTwoOperations() {
        assertEquals(1, Solution().minOperations("acb"))
        assertEquals(2, Solution().minOperations("bca"))
    }

    @Test
    fun threeOperations() {
        assertEquals(3, Solution().minOperations("cba"))
        assertEquals(3, Solution().minOperations("dbca"))
    }
}
