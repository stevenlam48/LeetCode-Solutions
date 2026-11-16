package strobogrammaticnumberii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StrobogrammaticNumberIiTest {
    @Test
    fun `length two`() {
        val result = Solution().findStrobogrammatic(2)
        assertEquals(setOf("11", "69", "88", "96"), result.toSet())
        assertEquals(4, result.size)
    }

    @Test
    fun `length three`() {
        val result = Solution().findStrobogrammatic(3)
        assertEquals(12, result.size)
        assertEquals(true, result.all { it.length == 3 && it[0] != '0' })
    }

    @Test
    fun `length one includes zero`() {
        assertEquals(setOf("0", "1", "8"), Solution().findStrobogrammatic(1).toSet())
    }

    @Test
    fun `length zero contains empty string`() {
        assertEquals(listOf(""), Solution().findStrobogrammatic(0))
    }
}
