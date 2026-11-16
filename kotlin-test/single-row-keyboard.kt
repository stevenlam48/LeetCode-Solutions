package singlerowkeyboard

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SingleRowKeyboardTest {
    private val solution = Solution()

    @Test
    fun `moves backward through alphabet`() {
        assertEquals(4, solution.calculateTime("abcdefghijklmnopqrstuvwxyz", "cba"))
    }

    @Test
    fun `custom keyboard layout`() {
        assertEquals(73, solution.calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"))
    }

    @Test
    fun `repeated character costs nothing`() {
        assertEquals(0, solution.calculateTime("abcdefghijklmnopqrstuvwxyz", "aaaa"))
    }

    @Test
    fun `empty word costs nothing`() {
        assertEquals(0, solution.calculateTime("abcdefghijklmnopqrstuvwxyz", ""))
    }
}
