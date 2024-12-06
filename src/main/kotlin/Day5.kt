class Day5 {
    val testAnswer1 = "143"
    fun part1(input: List<String>): String {
        var ans = 0L
        var o = 0
        val b = ArrayList<Int>()
        val c = ArrayList<Int>()
        for(s in input) {
            if(s.isBlank())break
            if(s.length != 5)break
            o++
            val a = s.split("|").map { it.toInt() }
            val p1 = a[0]
            val p2 = a[1]
            b.add(p1)
            c.add(p2)
        }
        var oo = 0
        for(s in input) {
            oo++
            if(oo <= o || s.isBlank())continue
            val a = s.split(",").map { it.toInt() }
            if(ok(a, b, c)) ans+= middle(a)
        }
        return "$ans"
    }

    private fun ok(a: List<Int>, b: java.util.ArrayList<Int>, c: java.util.ArrayList<Int>): Boolean {
        for(i in 1 until a.size) {
            for(j in 0 until b.size){
                if(a[i - 1] == c[j] && a[i] == b[j]) {
                    return false
                }
            }
        }
        return true
    }
    private fun middle(a: List<Int>): Int {
        return a[a.size / 2]
    }

    val testAnswer2 = "123"
    fun part2(input: List<String>): String {
        var ans = 0L
        var o = 0
        val b = ArrayList<Int>()
        val c = ArrayList<Int>()
        for(s in input) {
            if(s.isBlank())break
            if(s.length != 5)break
            o++
            val a = s.split("|").map { it.toInt() }
            val p1 = a[0]
            val p2 = a[1]
            b.add(p1)
            c.add(p2)
        }
        var oo = 0
        for(s in input) {
            oo++
            if(oo <= o || s.isBlank())continue
            val a = s.split(",").map { it.toInt() }
            if(!ok(a, b, c)) ans+= middle2(a, b, c)
        }
        return "$ans"
    }

    private fun middle2(a: List<Int>, b: ArrayList<Int>, c: ArrayList<Int>): Int {
        // sort a based on rules in b and c
        // if b[i] is lower than c[i] then if b[i] is in a then b[i] should be before c[i]

        val d = a.toIntArray()
        for(t in 0 until d.size * d.size) {
            for (i in 1 until d.size) {
                val p = d[i - 1]
                val n = d[i]
                for (j in 0 until b.size) {
                    if (p != c[j] || n != b[j]) {
                        continue
                    }

                    d[i - 1] = n
                    d[i] = p


                }

            }
        }
        return d[d.size / 2]

    }


}
