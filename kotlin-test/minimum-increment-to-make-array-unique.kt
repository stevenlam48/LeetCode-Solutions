package minimumincrementtomakearrayunique
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumIncrementToMakeArrayUniqueTest {
    @Test
    fun firstExample() {
        assertEquals(1, Solution().minIncrementForUnique(intArrayOf(1, 2, 2)))
    }

    @Test
    fun secondExample() {
        assertEquals(6, Solution().minIncrementForUnique(intArrayOf(3, 2, 1, 2, 1, 7)))
    }

    @Test
    fun emptyAndSingleElementInputs() {
        assertEquals(0, Solution().minIncrementForUnique(intArrayOf()))
        assertEquals(0, Solution().minIncrementForUnique(intArrayOf(5)))
    }

    @Test
    fun alreadyUnique() {
        assertEquals(0, Solution().minIncrementForUnique(intArrayOf(1, 2, 3)))
    }

    @Test
    fun allDuplicates() {
        assertEquals(3, Solution().minIncrementForUnique(intArrayOf(5, 5, 5)))
    }
}
