package validpermutationsfordisequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidPermutationsForDiSequenceTest {
    @Test
    fun singleCharacterPatterns() {
        assertEquals(1, Solution().numPermsDISequence("D"))
        assertEquals(1, Solution().numPermsDISequence("I"))
    }

    @Test
    fun lengthTwoPatterns() {
        assertEquals(2, Solution().numPermsDISequence("ID"))
        assertEquals(2, Solution().numPermsDISequence("DI"))
    }

    @Test
    fun leetCodeExamples() {
        assertEquals(5, Solution().numPermsDISequence("DID"))
        assertEquals(3, Solution().numPermsDISequence("IDD"))
        assertEquals(3, Solution().numPermsDISequence("DDI"))
        assertEquals(3, Solution().numPermsDISequence("IID"))
    }

    @Test
    fun allSameDirection() {
        assertEquals(1, Solution().numPermsDISequence("DDDD"))
        assertEquals(1, Solution().numPermsDISequence("IIII"))
        assertEquals(4, Solution().numPermsDISequence("IIID"))
    }

    @Test
    fun alternatingPatterns() {
        assertEquals(16, Solution().numPermsDISequence("IDID"))
        assertEquals(16, Solution().numPermsDISequence("DIDI"))
    }
}
