package fizzbuzzmultithreaded

import java.util.concurrent.locks.ReentrantLock

// Time:  O(n)
// Space: O(1)

class FizzBuzz(private val n: Int) {
    private var curr = 0
    private val lock = ReentrantLock()
    private val cond = lock.newCondition()

    fun fizz(printFizz: () -> Unit) {
        for (i in 1..n) {
            lock.lock()
            try {
                while (curr % 4 != 0) {
                    cond.await()
                }
                ++curr
                if (i % 3 == 0 && i % 5 != 0) {
                    printFizz()
                }
                cond.signalAll()
            } finally {
                lock.unlock()
            }
        }
    }

    fun buzz(printBuzz: () -> Unit) {
        for (i in 1..n) {
            lock.lock()
            try {
                while (curr % 4 != 1) {
                    cond.await()
                }
                ++curr
                if (i % 3 != 0 && i % 5 == 0) {
                    printBuzz()
                }
                cond.signalAll()
            } finally {
                lock.unlock()
            }
        }
    }

    fun fizzbuzz(printFizzBuzz: () -> Unit) {
        for (i in 1..n) {
            lock.lock()
            try {
                while (curr % 4 != 2) {
                    cond.await()
                }
                ++curr
                if (i % 3 == 0 && i % 5 == 0) {
                    printFizzBuzz()
                }
                cond.signalAll()
            } finally {
                lock.unlock()
            }
        }
    }

    fun number(printNumber: (Int) -> Unit) {
        for (i in 1..n) {
            lock.lock()
            try {
                while (curr % 4 != 3) {
                    cond.await()
                }
                ++curr
                if (i % 3 != 0 && i % 5 != 0) {
                    printNumber(i)
                }
                cond.signalAll()
            } finally {
                lock.unlock()
            }
        }
    }
}
