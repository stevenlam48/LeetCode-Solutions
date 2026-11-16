package designphonedirectory

// init:     Time: O(n), Space: O(n)
// get:      Time: O(1), Space: O(1)
// check:    Time: O(1), Space: O(1)
// release:  Time: O(1), Space: O(1)

class PhoneDirectory(maxNumbers: Int) {
    private var curr = 0
    private val numbers = IntArray(maxNumbers) { it }
    private val used = BooleanArray(maxNumbers)

    fun get(): Int {
        if (curr == numbers.size) {
            return -1
        }
        val number = numbers[curr++]
        used[number] = true
        return number
    }

    fun check(number: Int): Boolean {
        if (number < 0 || number >= numbers.size) {
            return false
        }
        return !used[number]
    }

    fun release(number: Int) {
        if (number < 0 || number >= numbers.size || !used[number]) {
            return
        }
        used[number] = false
        numbers[--curr] = number
    }
}
