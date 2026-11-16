package numberofwonderfulsubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWonderfulSubstringsTest {
    @Test
    fun firstExample() {
        assertEquals(4L, Solution().wonderfulSubstrings("aba"))
    }

    @Test
    fun secondExample() {
        assertEquals(9L, Solution().wonderfulSubstrings("aabb"))
    }

    @Test
    fun thirdExample() {
        assertEquals(2L, Solution().wonderfulSubstrings("he"))
    }

    @Test
    fun emptyInput() {
        assertEquals(0L, Solution().wonderfulSubstrings(""))
    }
}
