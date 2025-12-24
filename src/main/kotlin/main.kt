import solutions.DayEight
import solutions.DayFive
import solutions.DayFour
import solutions.DayOne
import solutions.DaySeven
import solutions.DaySix
import solutions.DayThree
import solutions.DayTwo

fun main() {
    val firstResult = DayOne("1a.txt").first()
    println("Day One A: " + firstResult)
    val secondResult = DayOne("1a.txt").second()
    println("Day One B: " + secondResult)
    val thirdResult = DayTwo("2a.csv").first()
    println("Day Two A: " + thirdResult)
    val fourthResult = DayTwo("2a.csv").second()
    println("Day Two B: " + fourthResult)
    val fifthResult = DayThree("3a.txt").first()
    println("Day Three A: " + fifthResult)
    val sixthResult = DayThree("3a.txt").second()
    println("Day Three B: " + sixthResult)
    val seventhResult = DayFour("4a.txt").first()
    println("Day Four A: " + seventhResult)
    val eigthResult = DayFour("4a.txt").second()
    println("Day Four B: " + eigthResult)
    val ninthResult = DayFive("5a.txt").first()
    println("Day Five A: " + ninthResult)
    val tenthResult = DayFive("5a.txt").second()
    println("Day Five B: " + tenthResult)
    val eleventhResult = DaySix("6a.txt").first()
    println("Day Six A: " + eleventhResult)
    val twelfthResult = DaySix("6a.txt").second()
    println("Day Six B: " + twelfthResult)
    val thirteenthResult = DaySeven("7a.txt").first()
    println("Day Seven A: " + thirteenthResult)
    val fourteenthResult = DaySeven("7a.txt").second()
    println("Day Seven B: " + fourteenthResult)
    val fifteenthResult = DayEight("8a.txt").first(1000)
    println("Day Eight A: " + fifteenthResult)
    val sixteenthResult = DayEight("8a.txt").second()
    println("Day Eight B: " + sixteenthResult)
}