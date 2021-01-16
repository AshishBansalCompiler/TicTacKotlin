package tictactoe
import java.util.*
val first = 'X'
val second = 'O'
val empty = '_'


fun checkorLoose(line : CharArray) : String? {
    var firstCount = 0
    var secondCount = 0
    var emptyCount = 0
    var array = charArrayOf(line[0].toChar())

    for (i in 0 .. line.size-1) {
        if (line[i].toChar().equals(first)) {
            firstCount++
        } else if (line[i].equals(second)) {
            secondCount++
        } else {
            emptyCount++;
        }
    }
    if (Math.abs(firstCount-secondCount) > 1) {
        return null
    }
    var rowCountFirst = 0
    var rowCountSecond = 0
    var flagX = false
    var flagY = false
    for (i in 0 .. 8 step 3) {
        rowCountFirst = 0
        rowCountSecond = 0
        for (j in i .. i+2) {
            if (line[j].equals(first)) {
                rowCountFirst++
            } else if (line[j].equals(second)) {
                rowCountSecond++
            } else {
                break
            }
        }
        if (rowCountFirst == 3) {
            flagX = true
        } else if (rowCountSecond == 3) {
            flagY = true
        }
    }

    if (flagX && flagY) {
        return null
    } else if (flagX) {
        return "X wins"
    } else if (flagY) {
        return "O wins"
    }
    flagX = false
    flagY = false

    for (i in 0 .. 2) {
        rowCountFirst = 0
        rowCountSecond = 0

        for (j in i .. i+6 step 3) {
            if (line[j].equals(first)) {
                rowCountFirst++
            } else if (line[j].equals(second)) {
                rowCountSecond++
            } else {
                break
            }
        }
        if (rowCountFirst == 3) {
            flagX = true
        } else if (rowCountSecond == 3) {
            flagY = true
        }
    }

    if (flagX && flagY) {
        return null
    } else if (flagX) {
        return("X wins")
    } else if (flagY) {
        return("O wins")
    }
    flagX = false
    flagY = false
    rowCountFirst = 0
    rowCountSecond = 0
    for(i in 0 .. 8 step 4) {
        if (line[i].equals(first)) {
            rowCountFirst++
        } else if (line[i].equals(second)) {
            rowCountSecond++
        } else {
            break
        }
        if (rowCountFirst == 3) {
            return("X wins")
        } else if (rowCountSecond == 3) {
            return("O wins")
        }
    }

    rowCountFirst = 0
    rowCountSecond = 0

    for(i in 2 .. 7 step 2) {
        if (line[i].equals(first)) {
            rowCountFirst++
        } else if (line[i].equals(second)) {
            rowCountSecond++
        } else {
            break
        }
        if (rowCountFirst == 3 && rowCountSecond == 3) {
            return null
        }
        if (rowCountFirst == 3) {
            return ("X wins")
        } else if (rowCountSecond == 3) {
            return("O wins")
        }
    }

    if (emptyCount > 0 ) {
        return null
    } else {
        return "Draw"
    }
}
fun printBoard(entry:CharArray) {
    println("---------")
    println("| ${entry[0]} ${entry[1]} ${entry[2]} |")
    println("| ${entry[3]} ${entry[4]} ${entry[5]} |")
    println("| ${entry[6]} ${entry[7]} ${entry[8]} |")
    println("---------")
}

fun main() {
    var mainStr = "_________"
    printBoard(mainStr.toCharArray())
    val line = CharArray(9)
    for (i in 0..mainStr.length - 1) {
        line[i] = mainStr[i].toChar()
    }
    val TwoD = arrayOf(
        charArrayOf(line[0], line[1], line[2]), charArrayOf(line[3], line[4], line[5]),
        charArrayOf(line[6], line[7], line[8])
    )
    var flag = true
    var moveMan = 'X'
    while (flag) {
        print("Enter the coordinates:")
        val line1 = readLine()!!.toString()
        val numbers = line1.split(" ")
        val first = numbers[0].toIntOrNull()
        val second = numbers[1].toIntOrNull()
        if (first == null || second == null) {
            println("You should enter numbers!")
        } else if (first < 0 || first > 3 || second < 0 || second > 3) {
            println("Coordinates should be from 1 to 3!")
        } else if (!TwoD[first-1][second-1].equals('_')) {
            println("This cell is occupied! Choose another one!")
        } else {
            line[3*(first-1) + second-1] = moveMan
            TwoD[first-1][second-1] = moveMan
            if (moveMan.equals('X')) {
                moveMan = 'O'
            } else {
                moveMan = 'X'
            }
            printBoard(line)
            checkorLoose(line)?.let {
                print(it)
                flag = false
            }
        }

    }
}














