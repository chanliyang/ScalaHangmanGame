package ch.makery.address.model

class Hangman(val word: String) {
  private var guessedWord: Array[Char] = Array.fill(word.length)('_')
  private var attemptsLeft: Int = 6
  private var guessedLetters: Set[Char] = Set()

  def getGuessedWord: String = guessedWord.mkString(" ")

  def getAttemptsLeft: Int = attemptsLeft

  def guess(letter: Char): Boolean = {
    if (guessedLetters.contains(letter)) {
      false
    } else {
      guessedLetters += letter
      if (word.contains(letter)) {
        for (i <- word.indices) {
          if (word(i) == letter) {
            guessedWord(i) = letter
          }
        }
        true
      } else {
        attemptsLeft -= 1
        false
      }
    }
  }

  def isGameOver: Boolean = attemptsLeft == 0 || guessedWord.mkString == word
}
