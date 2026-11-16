package uniquemorsecodewords

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniqueMorseCodeWordsTest {
    @Test
    fun leetCodeExample() {
        assertEquals(2, Solution().uniqueMorseRepresentations(arrayOf("gin", "zen", "gig", "msg")))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, Solution().uniqueMorseRepresentations(emptyArray()))
    }

    @Test
    fun oneWord() {
        assertEquals(1, Solution().uniqueMorseRepresentations(arrayOf("a")))
    }

    @Test
    fun duplicateWordsHaveOneRepresentation() {
        assertEquals(1, Solution().uniqueMorseRepresentations(arrayOf("kotlin", "kotlin", "kotlin")))
    }
}
