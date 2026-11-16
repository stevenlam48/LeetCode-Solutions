package maximumfrequencystack

// Time:  O(1)
// Space: O(n)

class FreqStack {
    private val freq = HashMap<Int, Int>()
    private val group = HashMap<Int, MutableList<Int>>()
    private var maxFreq = 0

    fun push(x: Int) {
        freq[x] = (freq[x] ?: 0) + 1
        if (freq[x]!! > maxFreq) {
            maxFreq = freq[x]!!
        }
        group.getOrPut(freq[x]!!) { mutableListOf() }.add(x)
    }

    fun pop(): Int {
        val x = group[maxFreq]!!.removeAt(group[maxFreq]!!.size - 1)
        if (group[maxFreq]!!.isEmpty()) {
            group.remove(maxFreq)
            --maxFreq
        }
        freq[x] = freq[x]!! - 1
        if (freq[x] == 0) {
            freq.remove(x)
        }
        return x
    }
}
