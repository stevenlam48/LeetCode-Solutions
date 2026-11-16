package simplebanksystem

// Time:  ctor:     O(1)
//        transer:  O(1)
//        deposit:  O(1)
//        withdraw: O(1)
// Space: O(1)
class Bank(private val balance: LongArray) {
    fun transfer(account1: Int, account2: Int, money: Long): Boolean {
        if (account2 >= 1 && account2 <= balance.size && withdraw(account1, money)) {
            return deposit(account2, money)
        }
        return false
    }

    fun deposit(account: Int, money: Long): Boolean {
        if (account >= 1 && account <= balance.size) {
            balance[account - 1] += money
            return true
        }
        return false
    }

    fun withdraw(account: Int, money: Long): Boolean {
        if (account >= 1 && account <= balance.size && balance[account - 1] >= money) {
            balance[account - 1] -= money
            return true
        }
        return false
    }
}
