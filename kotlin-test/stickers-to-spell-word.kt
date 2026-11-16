package stickerstospellword

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StickersToSpellWordTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.minStickers(arrayOf("with", "example", "science"), "thehat"))
    }

    @Test
    fun testExample2() {
        assertEquals(-1, solution.minStickers(arrayOf("notice", "possible"), "basicbasic"))
    }

    @Test
    fun testSingleSticker() {
        assertEquals(1, solution.minStickers(arrayOf("abc"), "abc"))
    }

    @Test
    fun testMultipleCopies() {
        assertEquals(2, solution.minStickers(arrayOf("ab"), "aabb"))
    }

    @Test
    fun testMissingLetter() {
        assertEquals(-1, solution.minStickers(arrayOf("ab"), "abc"))
    }
}
