package utf8validation

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Utf8ValidationTest {
    @Test
    fun validTwoByteSequence() {
        assertTrue(Solution().validUtf8(intArrayOf(197, 130, 1)))
    }

    @Test
    fun invalidContinuationByte() {
        assertFalse(Solution().validUtf8(intArrayOf(235, 140, 4)))
    }

    @Test
    fun validFourByteSequence() {
        assertTrue(Solution().validUtf8(intArrayOf(240, 162, 138, 149)))
    }

    @Test
    fun incompleteSequence() {
        assertFalse(Solution().validUtf8(intArrayOf(226, 130)))
    }
}
