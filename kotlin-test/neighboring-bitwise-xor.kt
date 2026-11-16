package neighboringbitwisexor

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class NeighboringBitwiseXorTest {
    @Test
    fun `accepts derived array from original with equal endpoints`() {
        assertTrue(Solution().doesValidArrayExist(intArrayOf(1, 1, 0)))
    }

    @Test
    fun `accepts derived array from original with different endpoints`() {
        assertTrue(Solution().doesValidArrayExist(intArrayOf(1, 1)))
    }

    @Test
    fun `rejects impossible derived array`() {
        assertFalse(Solution().doesValidArrayExist(intArrayOf(1, 0)))
    }

    @Test
    fun `handles single element`() {
        assertTrue(Solution().doesValidArrayExist(intArrayOf(0)))
        assertFalse(Solution().doesValidArrayExist(intArrayOf(1)))
    }
}
