package defanginganipaddress

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DefangingAnIpAddressTest {
    private val solution = Solution()

    @Test
    fun standardAddress() {
        assertEquals("1[.]1[.]1[.]1", solution.defangIPaddr("1.1.1.1"))
    }

    @Test
    fun anotherAddress() {
        assertEquals("255[.]100[.]50[.]0", solution.defangIPaddr("255.100.50.0"))
    }

    @Test
    fun addressWithoutDots() {
        assertEquals("localhost", solution.defangIPaddr("localhost"))
    }

    @Test
    fun emptyAddress() {
        assertEquals("", solution.defangIPaddr(""))
    }
}
