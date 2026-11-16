package pyramidtransitionmatrix

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PyramidTransitionMatrixTest {
    private val solution = Solution()

    @Test
    fun validCase1() {
        val actual = solution.pyramidTransition("BCD", listOf("BCC", "CDE", "CEA", "FFF"))
        assertTrue(actual)
    }

    @Test
    fun validCase2() {
        val actual = solution.pyramidTransition("AAAA", listOf("AAB", "AAC", "BCD", "BBE", "DEF"))
        assertFalse(actual)
    }

    @Test
    fun validCase3_singleBlock() {
        val actual = solution.pyramidTransition("A", emptyList())
        assertTrue(actual)
    }

    @Test
    fun validCase4_multipleChoices() {
        val actual = solution.pyramidTransition(
            "ABC",
            listOf("ABD", "ABE", "BCE", "BCF", "DEF", "EFG")
        )
        assertTrue(actual)
    }

    @Test
    fun validCase5_missingTransition() {
        val actual = solution.pyramidTransition("AB", listOf("ACD"))
        assertFalse(actual)
    }

    @Test
    fun validCase6_backtracksToSuccessfulPath() {
        val actual = solution.pyramidTransition(
            "AABA",
            listOf("AAA", "AAB", "ABA", "ABB", "BAC")
        )
        assertFalse(actual)
    }
}
