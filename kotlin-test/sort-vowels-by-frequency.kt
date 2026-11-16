package sortvowelsbyfrequency

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortVowelsByFrequencyTest {
    @Test
    fun equalFrequenciesUseFirstAppearance() {
        assertEquals("aeiou", Solution().sortVowels("aeiou"))
    }

    @Test
    fun higherFrequencyVowelsComeFirst() {
        assertEquals("ooeeai", Solution().sortVowels("ooaeei"))
    }

    @Test
    fun frequencyTieUsesOriginalVowelOrder() {
        assertEquals("iieeoo", Solution().sortVowels("ieioeo"))
    }

    @Test
    fun consonantsAndUppercaseRemainInPlace() {
        assertEquals("booeeaiz", Solution().sortVowels("booaeeiz"))
        assertEquals("AEIOUxyz", Solution().sortVowels("AEIOUxyz"))
    }

    @Test
    fun emptyAndNoLowercaseVowels() {
        assertEquals("", Solution().sortVowels(""))
        assertEquals("bcdfg", Solution().sortVowels("bcdfg"))
    }
}
