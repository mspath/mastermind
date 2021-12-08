package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    var rightPosition = 0
    var wrongPosition = 0

    var secretRest = ""
    var guessRest = ""

    for ((index, next) in guess.withIndex()) {
        if (secret[index] == guess[index]) rightPosition++
        else {
            secretRest = secretRest + secret[index]
            guessRest = guessRest + next
        }
    }

    var secretArray = secretRest.toCharArray()

    for ((index, next) in guessRest.withIndex()) {
        println("next: ${next}")
        if (next in secretArray) {
            wrongPosition++
            secretArray[secretArray.indexOf(next)] = 'X'
        }
    }

    return Evaluation(rightPosition, wrongPosition)
}
