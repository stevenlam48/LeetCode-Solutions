package majorityfrequencycharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MajorityFrequencyCharactersTest {
    @Test
    fun selectsLargestFrequencyGroup() {
        assertEquals("abc", Solution().majorityFrequencyGroup("aaabbbcccdde"))
    }

    @Test
    fun breaksGroupSizeTieWithHigherFrequency() {
        assertEquals("de", Solution().majorityFrequencyGroup("abeeeedddd"))
    }

    @Test
    fun returnsEveryCharacterWhenAllFrequenciesMatch() {
        assertEquals("abc", Solution().majorityFrequencyGroup("aabbcc"))
    }

    @Test
    fun handlesEmptyAndSingleCharacterStrings() {
        assertEquals("", Solution().majorityFrequencyGroup(""))
        assertEquals("z", Solution().majorityFrequencyGroup("z"))
    }
}
