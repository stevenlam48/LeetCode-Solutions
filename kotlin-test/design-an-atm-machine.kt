package designanatmmachine

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DesignAnAtmMachineTest {
    @Test
    fun testExample() {
        val atm = ATM()
        atm.deposit(intArrayOf(0, 0, 1, 2, 1))
        assertArrayEquals(intArrayOf(0, 0, 1, 0, 1), atm.withdraw(600))
        atm.deposit(intArrayOf(0, 1, 0, 1, 1))
        assertArrayEquals(intArrayOf(-1), atm.withdraw(600))
        assertArrayEquals(intArrayOf(0, 1, 0, 0, 1), atm.withdraw(550))
    }

    @Test
    fun testWithdrawEmpty() {
        val atm = ATM()
        assertArrayEquals(intArrayOf(-1), atm.withdraw(20))
    }

    @Test
    fun testExactDenominations() {
        val atm = ATM()
        atm.deposit(intArrayOf(1, 1, 1, 1, 1))
        assertArrayEquals(intArrayOf(1, 0, 0, 0, 0), atm.withdraw(20))
        assertArrayEquals(intArrayOf(0, 1, 0, 0, 0), atm.withdraw(50))
        assertArrayEquals(intArrayOf(0, 0, 1, 0, 0), atm.withdraw(100))
        assertArrayEquals(intArrayOf(0, 0, 0, 1, 0), atm.withdraw(200))
        assertArrayEquals(intArrayOf(0, 0, 0, 0, 1), atm.withdraw(500))
    }

    @Test
    fun testRejectedDoesNotModify() {
        val atm = ATM()
        atm.deposit(intArrayOf(0, 0, 0, 3, 0))
        assertArrayEquals(intArrayOf(-1), atm.withdraw(100))
        assertArrayEquals(intArrayOf(0, 0, 0, 1, 0), atm.withdraw(200))
    }

    @Test
    fun testGreedyLargestFirst() {
        val atm = ATM()
        atm.deposit(intArrayOf(0, 0, 0, 0, 2))
        assertArrayEquals(intArrayOf(0, 0, 0, 0, 1), atm.withdraw(500))
    }
}
