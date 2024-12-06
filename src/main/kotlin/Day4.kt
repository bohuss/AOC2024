class Day4 {
    val testAnswer1 = "18"
    fun part1(input: List<String>): String {
        var ans = 0L
        val b = ArrayList<String>()
        for(s in input) {
            b.add(s)
        }
        val R = b.size
        val C = b[0].length
        for(i in 0 until R) {
            for(j in 0 until C) {
                ans += findXmas(b, i, j)
            }
        }
        return "$ans"
    }

    private fun findXmas(b: ArrayList<String>, y: Int, x: Int): Int {
        val R = b.size
        val C = b[0].length
        var ans = 0
        for(dx in -1..1) {
            for(dy in -1..1) {
                if(dx == 0 && dy == 0) continue
                var id = 0
                val xmas = "XMAS"
                while(id < 4 && x + dx * id in 0 until R && y + dy * id in 0 until C) {
                    if(b[x + dx * id][y + dy * id] != xmas[id++]){
                        break
                    }
                }
                if(id == 4) {
                    ans++
                }
            }
        }
        return ans
    }

    private fun findXMas(b: ArrayList<String>, i: Int, j: Int): Int {
        val R = b.size
        val C = b[0].length
        if(b[i][j] != 'A' || i - 1 < 0 || i + 1 >= R || j - 1 < 0 || j + 1 >= C) {
            return 0
        }

        val corners = "" + b[i - 1][j - 1] + b[i - 1][j + 1] + b[i + 1][j + 1] + b[i + 1][j - 1]
        if(corners in arrayOf("MSSM", "SSMM", "SMMS", "MMSS")) {
            return 1
        }
        return 0
    }


    val testAnswer2 = "9"
    fun part2(input: List<String>): String {
        var ans = 0L
        val b = ArrayList<String>()
        for(s in input) {
            b.add(s)
        }
        val R = b.size
        val C = b[0].length
        for(i in 0 until R) {
            for(j in 0 until C) {
                ans += findXMas(b, i, j)
            }
        }
        return "$ans"
    }


}
