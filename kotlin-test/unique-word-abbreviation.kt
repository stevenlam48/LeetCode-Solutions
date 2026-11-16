package uniquewordabbreviation

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UniqueWordAbbreviationTest {
    @Test
    fun acceptsWordsAbsentFromAbbreviationGroup() {
        val validator = ValidWordAbbr(arrayOf("deer", "door", "cake", "card"))
        assertTrue(validator.isUnique("dog"))
        assertTrue(validator.isUnique("cart"))
    }

    @Test
    fun rejectsDifferentWordWithSameAbbreviation() {
        val validator = ValidWordAbbr(arrayOf("deer", "door", "cake", "card"))
        assertFalse(validator.isUnique("door"))
        assertFalse(validator.isUnique("dour"))
    }

    @Test
    fun acceptsDictionaryWordWithoutAbbreviationCollision() {
        val validator = ValidWordAbbr(arrayOf("dog"))
        assertTrue(validator.isUnique("dog"))
        assertTrue(validator.isUnique("cat"))
    }

    @Test
    fun emptyDictionaryAndShortWords() {
        val validator = ValidWordAbbr(emptyArray())
        assertTrue(validator.isUnique("a"))
        assertTrue(validator.isUnique("to"))
    }
}
