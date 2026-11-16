package findtheoriginaltypedstringii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheOriginalTypedStringIiTest {
    private val solution = Solution()

    @Test
    fun sevenCharacterOriginalStrings() {
        assertEquals(5, solution.possibleStringCount("aabbccdd", 7))
    }

    @Test
    fun maximumLengthOriginalString() {
        assertEquals(1, solution.possibleStringCount("aabbccdd", 8))
    }

    @Test
    fun twoLongRuns() {
        assertEquals(8, solution.possibleStringCount("aaabbb", 3))
    }

    @Test
    fun originalStringCannotBeLongerThanTypedString() {
        assertEquals(0, solution.possibleStringCount("aaaa", 5))
    }

    @Test
    fun productUsesModuloArithmetic() {
        assertEquals(511620083, solution.possibleStringCount("aabb".repeat(20), 1))
    }
}
