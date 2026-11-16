package printzeroevenodd

// Time:  O(n)
// Space: O(1)

class ZeroEvenOdd(private val n: Int) {
    private var curr = 0
    private val lock = Object()

    fun zero(printNumber: (Int) -> Unit) {
        repeat(n) {
            synchronized(lock) {
                while (curr % 2 != 0) {
                    lock.wait()
                }
                ++curr
                printNumber(0)
                lock.notifyAll()
            }
        }
    }

    fun even(printNumber: (Int) -> Unit) {
        for (i in 2..n step 2) {
            synchronized(lock) {
                while (curr % 4 != 3) {
                    lock.wait()
                }
                ++curr
                printNumber(i)
                lock.notifyAll()
            }
        }
    }

    fun odd(printNumber: (Int) -> Unit) {
        for (i in 1..n step 2) {
            synchronized(lock) {
                while (curr % 4 != 1) {
                    lock.wait()
                }
                ++curr
                printNumber(i)
                lock.notifyAll()
            }
        }
    }
}
