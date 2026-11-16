package movepiecestoobtainastring

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MovePiecesToObtainAStringTest {
    @Test
    fun example1() {
        assertTrue(Solution().canChange("_L__R__R_", "L______RR"))
    }

    @Test
    fun example2() {
        assertFalse(Solution().canChange("R_L___", "___LR_"))
    }

    @Test
    fun example3() {
        assertFalse(Solution().canChange("R_L___", "L__R__"))
    }

    @Test
    fun identical() {
        assertTrue(Solution().canChange("LR", "LR"))
    }

    @Test
    fun differentPieces() {
        assertFalse(Solution().canChange("L", "R"))
    }

    @Test
    fun moveRight() {
        assertTrue(Solution().canChange("R__", "__R"))
        assertFalse(Solution().canChange("__R", "R__"))
    }
}
