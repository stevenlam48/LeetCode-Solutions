package frequencytracker

// Time:  ctor:         O(1)
//        add:          O(1)
//        deleteOne:    O(1)
//        hasFrequency: O(1)
// Space: O(min(n, r))

class FrequencyTracker {
    private val cnt = HashMap<Int, Int>()
    private val freq = HashMap<Int, Int>()

    fun add(number: Int) {
        val count = cnt[number] ?: 0
        val oldFrequencyCount = (freq[count] ?: 0) - 1
        if (oldFrequencyCount == 0) {
            freq.remove(count)
        } else {
            freq[count] = oldFrequencyCount
        }
        val newCount = count + 1
        cnt[number] = newCount
        freq[newCount] = (freq[newCount] ?: 0) + 1
    }

    fun deleteOne(number: Int) {
        val count = cnt[number] ?: return
        val oldFrequencyCount = (freq[count] ?: 0) - 1
        if (oldFrequencyCount == 0) {
            freq.remove(count)
        } else {
            freq[count] = oldFrequencyCount
        }
        val newCount = count - 1
        freq[newCount] = (freq[newCount] ?: 0) + 1
        if (newCount == 0) {
            cnt.remove(number)
        } else {
            cnt[number] = newCount
        }
    }

    fun hasFrequency(frequency: Int): Boolean {
        return freq.containsKey(frequency)
    }
}
