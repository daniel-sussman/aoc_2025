import solutions.DayFive
import solutions.DayFour
import solutions.DayOne
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
}