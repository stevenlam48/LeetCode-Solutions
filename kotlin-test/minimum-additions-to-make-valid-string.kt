package minimumadditionstomakevalidstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAdditionsToMakeValidStringTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().addMinimum("b"))
    }

    @Test
    fun example2() {
        assertEquals(6, Solution().addMinimum("aaa"))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().addMinimum("abc"))
    }

    @Test
    fun twoChars() {
        assertEquals(1, Solution().addMinimum("ab"))
    }

    @Test
    fun skipMiddle() {
        assertEquals(1, Solution().addMinimum("ac"))
    }

    @Test
    fun outOfOrder() {
        assertEquals(3, Solution().addMinimum("bac"))
    }
}
