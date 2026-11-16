package checkifonestringswapcanmakestringsequal

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfOneStringSwapCanMakeStringsEqualTest {
    private val solution = Solution()

    @Test
    fun oneSwapMakesStringsEqual() {
        assertTrue(solution.areAlmostEqual("bank", "kanb"))
    }

    @Test
    fun swapCannotRepairStrings() {
        assertFalse(solution.areAlmostEqual("attack", "defend"))
    }

    @Test
    fun equalStringsNeedNoSwap() {
        assertTrue(solution.areAlmostEqual("kelb", "kelb"))
    }

    @Test
    fun fourDifferencesNeedMoreThanOneSwap() {
        assertFalse(solution.areAlmostEqual("abcd", "dcab"))
    }

    @Test
    fun oneDifferenceIsNotASwap() {
        assertFalse(solution.areAlmostEqual("aa", "ac"))
    }
}
