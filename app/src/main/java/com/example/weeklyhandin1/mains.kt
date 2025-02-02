package com.example.weeklyhandin1

fun main () {
// exercise 1

print("Enter ur age: ")

    //declare variables
    val ageInput = readLine()!!
    val age = ageInput.toIntOrNull() ?: -1 //if the input is invalide insert -1 as age

//checks if to age is under or over 18
    if (age in 0..18) {
        println("Ur to young to vote, wait a few years")
    } else if  (age >= 18) {
        println("Congrats you are old enough to vote")
    }
    else {
        println("invalid input")
    }


    // exercise 2
    val number1: Int = 23
    val number2: Int = 30
    val number3: Int = 20

    printMax(number1,number2, number3)
    printMin(number1,number2, number3)

    //exercise 3
    val numbersList: List<Int> = listOf(22,23,56,53,24)
val avg = calculateAverage(numbersList)
    println(avg)


    //exercise 4
    val cprNumber: Long = 1604991234
    val cprNumber2: Long = 4312401234

println(isCprValid(cprNumber))
    println(isCprValid(cprNumber2))


    // exercise 5
    for (num in 1..100){
        when {
            num % 3 == 0 && num % 5 == 0 -> println("FizzBuzz") // when the number can be divided by both 3 and 5
            num % 3 == 0 -> println("Fizz") // when the number can be divided with 3
            num % 5 == 0 -> println("Buzz")
            else -> println(num)
        }
    }
// exercise 6
    print("Enter your full name: ")
    val fullName = readLine()?.trim() ?: return
    val nameParts = fullName.split(" ")

    // if the name is smaller then 2
    if (nameParts.size < 2) {
        println("Please enter at least a first and last name.")
        return
    }

    val abbreviations = nameParts.dropLast(1) // takes all names but the last
        .map { it.first().uppercaseChar() + "." } // get the first letter the the split names and add .

    val lastName = nameParts.last()// gets the last name

    println(abbreviations.joinToString(" ") + " " + lastName)

    // exercise 7
    print("Enter your numerical grade (0-100): ")

    val grade = readLine()?.toIntOrNull() // reads the input

    if (grade == null || grade !in 0..100) { // checks if the input is valid
        println("Ivalid Grade enter a number between 0-100")
        return
        }

    val letterGrade = calculateGrade(grade)
    println("Your letter grade is: $letterGrade")


    //exercise 8
    val words = listOf("Dog", "Elephant", "Lion", "Snake", "Jaguar")
    val minLength = 5

    val filteredWords = filterWordsByLength(words, minLength)
    println("Words with length >= $minLength: $filteredWords")
}
//main ends here

//exercise 2 funtions
//finding the max
fun printMax(a: Int, b: Int, c:Int){
    val max = maxOf(a,b,c)
    println(max)
}
// finding min
fun printMin(a:Int, b: Int, c:Int){
    val min = minOf(a,b,c)
    println(min)
}

// exercise 3 function
fun calculateAverage (list: List<Int>): Double {
    return list.average()
}

// exercide 4 function
fun isCprValid(cpr: Long):Boolean {
    // convert to string to check length
    val  cprString = cpr.toString()

    if (cprString.length != 10) {
        return false
    }

    //extract the day and month
    val day = cpr / 100000000 // get the first 2 digits
    val month = (cpr / 1000000) %100 // gets the month

    if (day !in 1..31 || month !in 1..12) {
        return false
    }
    else return true
}

//exercise 7 function
fun calculateGrade (grade: Int): String {
    return when (grade) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        else -> "F"
    }
}

//exercise 8 function
fun filterWordsByLength(words: List<String>, minLength: Int): List<String> {
    return words.filter { it.length >= minLength }
}