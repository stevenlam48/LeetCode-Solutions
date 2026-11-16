package makearrayzerobysubtractingequalamounts

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MakeArrayZeroBySubtractingEqualAmountsTest {
    @Test
    fun `counts distinct positive values`() {
        assertEquals(3, Solution().minimumOperations(intArrayOf(1, 5, 0, 3, 5)))
    }

    @Test
    fun `ignores zero values`() {
        assertEquals(0, Solution().minimumOperations(intArrayOf(0, 0, 0)))
    }

    @Test
    fun `counts duplicated values once`() {
        assertEquals(1, Solution().minimumOperations(intArrayOf(2, 2, 2)))
    }

    @Test
    fun `handles empty array`() {
        assertEquals(0, Solution().minimumOperations(intArrayOf()))
    }
}
