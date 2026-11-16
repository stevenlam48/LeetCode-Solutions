package checkifdigitsareequalinstringafteroperationsii

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun hasSameDigits(s: String): Boolean {
        return check(s, 2) && check(s, 5)
    }

    private fun check(s: String, mod: Int): Boolean {
        var result = 0
        var cnt = 0
        var curr = 1
        for (i in 0..s.length - 2) {
            if (cnt == 0) {
                result = ((result + curr * (s[i] - s[i + 1])) % mod + mod) % mod
            }
            var x1 = s.length - 2 - i
            var c1 = 0
            while (x1 > 1 && x1 % mod == 0) {
                x1 /= mod
                ++c1
            }
            curr = (curr * x1) % mod
            cnt += c1
            var x2 = i + 1
            var c2 = 0
            while (x2 > 1 && x2 % mod == 0) {
                x2 /= mod
                ++c2
            }
            curr = (curr * pow(x2.toLong(), mod - 2, mod) % mod).toInt()
            cnt -= c2
        }
        return result == 0
    }

    private fun pow(a: Long, b: Int, m: Int): Long {
        var base = a % m
        var exp = b
        var result = 1L
        while (exp > 0) {
            if (exp and 1 == 1) {
                result = (result * base) % m
            }
            base = (base * base) % m
            exp = exp shr 1
        }
        return result
    }
}
