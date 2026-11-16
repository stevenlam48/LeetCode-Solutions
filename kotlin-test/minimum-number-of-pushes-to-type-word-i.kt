package minimumnumberofpushestotypewordi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfPushesToTypeWordITest {
    private val solution = Solution()

    @Test
    fun leetCodeExample() {
        assertEquals(5, solution.minimumPushes("abcde"))
    }

    @Test
    fun singleLetterNeedsOnePush() {
        assertEquals(1, solution.minimumPushes("a"))
    }

    @Test
    fun fillsFirstEightKeys() {
        assertEquals(8, solution.minimumPushes("abcdefgh"))
    }

    @Test
    fun putsNinthLetterOnSecondPushLevel() {
        assertEquals(10, solution.minimumPushes("abcdefghi"))
    }

    @Test
    fun handlesFullAlphabet() {
        assertEquals(56, solution.minimumPushes("abcdefghijklmnopqrstuvwxyz"))
    }

    @Test
    fun handlesEmptyWord() {
        assertEquals(0, solution.minimumPushes(""))
    }
}
