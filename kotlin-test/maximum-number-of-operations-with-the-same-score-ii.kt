package maximumnumberofoperationswiththesamescoreii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberofoperationswiththesamescoreiiTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().maxOperations(intArrayOf(3, 2, 1, 2, 3, 4)))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().maxOperations(intArrayOf(3, 2, 6, 1, 4)))
    }

    @Test
    fun twoElements() {
        assertEquals(1, Solution().maxOperations(intArrayOf(1, 1)))
    }

    @Test
    fun fourEqualElements() {
        assertEquals(2, Solution().maxOperations(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun onlyOneOperationPossible() {
        assertEquals(1, Solution().maxOperations(intArrayOf(1, 2, 4, 8)))
    }
}
