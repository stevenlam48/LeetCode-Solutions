package firstuniquecharacterinastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FirstUniqueCharacterInAStringTest {
    @Test
    fun example1() {
        assertEquals(0, Solution().firstUniqChar("leetcode"))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().firstUniqChar("loveleetcode"))
    }

    @Test
    fun noUnique() {
        assertEquals(-1, Solution().firstUniqChar("aabb"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(0, Solution().firstUniqChar("z"))
    }

    @Test
    fun allRepeated() {
        assertEquals(-1, Solution().firstUniqChar("aadadaad"))
    }
}
