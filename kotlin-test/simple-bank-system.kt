package simplebanksystem

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SimpleBankSystemTest {
    @Test
    fun `leetcode operation sequence`() {
        val balances = longArrayOf(10, 100, 20, 50, 30)
        val bank = Bank(balances)
        assertTrue(bank.withdraw(3, 10))
        assertTrue(bank.transfer(1, 2, 5))
        assertTrue(bank.transfer(5, 1, 20))
        assertTrue(bank.deposit(5, 20))
        assertFalse(bank.withdraw(3, 50))
        assertArrayEquals(longArrayOf(25, 105, 10, 50, 30), balances)
    }

    @Test
    fun `invalid accounts do not change balances`() {
        val balances = longArrayOf(20, 30)
        val bank = Bank(balances)
        assertFalse(bank.deposit(0, 5))
        assertFalse(bank.withdraw(3, 5))
        assertFalse(bank.transfer(1, 3, 5))
        assertArrayEquals(longArrayOf(20, 30), balances)
    }

    @Test
    fun `insufficient funds leave source unchanged`() {
        val balances = longArrayOf(20, 30)
        val bank = Bank(balances)
        assertFalse(bank.withdraw(1, 21))
        assertFalse(bank.transfer(1, 2, 21))
        assertArrayEquals(longArrayOf(20, 30), balances)
    }

    @Test
    fun `supports long balances`() {
        val balances = longArrayOf(5_000_000_000L, 0)
        val bank = Bank(balances)
        assertTrue(bank.transfer(1, 2, 3_000_000_000L))
        assertArrayEquals(longArrayOf(2_000_000_000L, 3_000_000_000L), balances)
    }
}
