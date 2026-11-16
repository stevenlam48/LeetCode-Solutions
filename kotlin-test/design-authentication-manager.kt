package designauthenticationmanager

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DesignAuthenticationManagerTest {
    @Test
    fun testExample() {
        val manager = AuthenticationManager(5)
        manager.renew("aaa", 1)
        manager.generate("aaa", 2)
        assertEquals(1, manager.countUnexpiredTokens(6))
        manager.generate("bbb", 7)
        manager.renew("aaa", 8)
        manager.renew("bbb", 10)
        assertEquals(0, manager.countUnexpiredTokens(15))
    }

    @Test
    fun testExpiryBoundary() {
        val manager = AuthenticationManager(3)
        manager.generate("t", 0)
        assertEquals(1, manager.countUnexpiredTokens(2))
        assertEquals(0, manager.countUnexpiredTokens(3))
    }

    @Test
    fun testRenewExtends() {
        val manager = AuthenticationManager(2)
        manager.generate("t", 0)
        manager.renew("t", 1)
        assertEquals(1, manager.countUnexpiredTokens(2))
        assertEquals(0, manager.countUnexpiredTokens(3))
    }

    @Test
    fun testRenewUnknown() {
        val manager = AuthenticationManager(5)
        manager.renew("nope", 1)
        assertEquals(0, manager.countUnexpiredTokens(1))
    }

    @Test
    fun testMultipleTokens() {
        val manager = AuthenticationManager(10)
        manager.generate("a", 0)
        manager.generate("b", 5)
        assertEquals(2, manager.countUnexpiredTokens(9))
        assertEquals(1, manager.countUnexpiredTokens(10))
    }
}
