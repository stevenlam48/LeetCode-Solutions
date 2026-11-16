package validateipaddress

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidateIpAddressTest {
    private val solution = Solution()

    @Test
    fun recognizesIPv4() {
        assertEquals("IPv4", solution.validIPAddress("192.168.1.1"))
        assertEquals("IPv4", solution.validIPAddress("0.0.0.0"))
        assertEquals("IPv4", solution.validIPAddress("255.255.255.255"))
    }

    @Test
    fun rejectsInvalidIPv4() {
        assertEquals("Neither", solution.validIPAddress("192.168.01.1"))
        assertEquals("Neither", solution.validIPAddress("256.1.1.1"))
        assertEquals("Neither", solution.validIPAddress("1.2.3"))
        assertEquals("Neither", solution.validIPAddress("1.2.3.4.5"))
        assertEquals("Neither", solution.validIPAddress("1.2.3.4."))
    }

    @Test
    fun recognizesIPv6() {
        assertEquals("IPv6", solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"))
        assertEquals("IPv6", solution.validIPAddress("1:2:3:4:5:6:7:8"))
    }

    @Test
    fun rejectsInvalidIPv6AndOtherInput() {
        assertEquals("Neither", solution.validIPAddress("2001:db8:85a3::8A2E:0370:7334"))
        assertEquals("Neither", solution.validIPAddress("2001:db8:85a3:0:0:8A2E:03700"))
        assertEquals("Neither", solution.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:733g"))
        assertEquals("Neither", solution.validIPAddress("not-an-ip"))
    }
}
