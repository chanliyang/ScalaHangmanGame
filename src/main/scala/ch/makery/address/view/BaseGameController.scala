package ch.makery.address.view

import scalafx.scene.control.{Label, TextField, Button}
import scalafx.scene.image.{Image, ImageView}

class BaseGameController(
                 word: String,
                 levelnumber: Int,
                 completionMessage: String, // New parameter for completion message
                 wordLabel: Label,
                 wordGuessing: Label,
                 GuessLeft: Label,
                 charTextField: TextField,
                 imageView: ImageView,
                 retryButton: Button
               ) {

  private var guessedWord = Array.fill(word.length)('*')
  private var guessedChars: String = ""
  private var remainingGuesses = 5

  def initialize(): Unit = {
    wordLabel.text = "Guess the word:"
    wordGuessing.text = guessedWord.mkString
    retryButton.visible = false
    imageView.image = new Image(s"Images/Level${levelnumber}/A0.png")
    GuessLeft.text = s"Guesses left: $remainingGuesses"
  }

  def submit(): Unit = {
    if (charTextField.text.value.nonEmpty && remainingGuesses > 0) {
      val enteredChar = charTextField.text.value.charAt(0)

      if (guessedChars.contains(enteredChar)) {
        wordLabel.text = s"You already guessed '$enteredChar'"
      } else {
        guessedChars += enteredChar

        if (word.contains(enteredChar)) {
          wordLabel.text = s"'$enteredChar' is in the word!"
          for (i <- word.indices) {
            if (word(i) == enteredChar) guessedWord(i) = enteredChar
          }
          wordGuessing.text = guessedWord.mkString
        } else {
          remainingGuesses -= 1
          wordLabel.text = s"'$enteredChar' is NOT in the word."
          updateImageView()

          if (GuessLeft != null) {
            GuessLeft.text = s"Guesses left: $remainingGuesses"
          }
        }

        charTextField.clear()

        if (guessedWord.mkString == word) {
          wordLabel.text = completionMessage
          disableInput()
        } else if (remainingGuesses == 0) {
          wordLabel.text = "No more guesses. You lost!"
          disableInput()
          retryButton.visible = true
        }
      }
    }
  }

  private def updateImageView(): Unit = {
    val imagePath = s"Images/Level${levelnumber}/A${5 - remainingGuesses}.png"
    imageView.image = new Image(imagePath)
  }

  private def disableInput(): Unit = {
    charTextField.disable = true
    retryButton.visible = true
  }

  def retry(): Unit = {
    guessedWord = Array.fill(word.length)('*')
    guessedChars = ""
    remainingGuesses = 5
    wordLabel.text = "Guess the word:"
    wordGuessing.text = guessedWord.mkString
    GuessLeft.text = s"Guesses left: $remainingGuesses"
    charTextField.disable = false
    retryButton.visible = false
    imageView.image = new Image(s"Images/Level${levelnumber}/A0.png")
  }
}
