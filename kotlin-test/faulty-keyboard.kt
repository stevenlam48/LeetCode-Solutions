package faultykeyboard

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FaultyKeyboardTest {
    @Test
    fun reversesTypedTextOnEachFault() {
        assertEquals("rtsng", Solution().finalString("string"))
    }

    @Test
    fun consecutiveFaultsCancelEachOther() {
        assertEquals("ponter", Solution().finalString("poiinter"))
    }

    @Test
    fun leavesTextUnchangedWithoutFaults() {
        assertEquals("code", Solution().finalString("code"))
    }

    @Test
    fun handlesOnlyFaultsAndEmptyInput() {
        assertEquals("", Solution().finalString("iii"))
        assertEquals("", Solution().finalString(""))
    }

    @Test
    fun handlesFaultsAtBothEnds() {
        assertEquals("ab", Solution().finalString("aib"))
        assertEquals("ab", Solution().finalString("iab"))
    }
}
