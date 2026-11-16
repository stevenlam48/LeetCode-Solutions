package numberofchangingkeys

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberOfChangingKeysTest {
    private val solution = Solution()

    @Test
    fun `case changes do not count as key changes`() {
        assertEquals(2, solution.countKeyChanges("aAbBcC"))
    }

    @Test
    fun `counts a transition between different letters`() {
        assertEquals(1, solution.countKeyChanges("aaAabBB"))
    }

    @Test
    fun `counts every transition when adjacent letters differ`() {
        assertEquals(4, solution.countKeyChanges("AbCdE"))
    }

    @Test
    fun `handles single and empty strings`() {
        assertEquals(0, solution.countKeyChanges("a"))
        assertEquals(0, solution.countKeyChanges(""))
    }

    @Test
    fun `counts changes across repeated mixed case groups`() {
        assertEquals(2, solution.countKeyChanges("aAbbBBcCc"))
    }
}
