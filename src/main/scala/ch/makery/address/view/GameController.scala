package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.scene.control.{Label, TextField, Button, Alert}
import scalafx.scene.image.{Image, ImageView}
import scalafxml.core.macros.sfxml

@sfxml
class GameController(
                      private val wordLabel: Label,
                      private val wordGuessing: Label,
                      private val GuessLeft: Label,
                      private val charTextField: TextField,
                      private val imageView: ImageView,
                      private val retryButton: Button
                    ) {

  private val word1 = "tree"
  private val levelnumber = 2

  private var guessedWord = Array.fill(word1.length)('*')
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
        wordLabel.text = s"You already guessed '$enteredChar'. Try another letter."
      } else {
        guessedChars += enteredChar

        if (word1.contains(enteredChar)) {
          wordLabel.text = s"'$enteredChar' is in the word!"
          for (i <- word1.indices) {
            if (word1(i) == enteredChar) guessedWord(i) = enteredChar
          }
          wordGuessing.text = guessedWord.mkString
        } else {
          remainingGuesses -= 1
          wordLabel.text = s"'$enteredChar' is NOT in the word."
          updateImageView()

          if (GuessLeft != null) { // Check if GuessLeft is not null
            GuessLeft.text = s"Guesses left: $remainingGuesses"
          }
        }

        charTextField.clear()

        if (guessedWord.mkString == word1) {
          wordLabel.text = "Yay! You guessed the word!"
          disableInput()
        } else if (remainingGuesses == 0) {
          wordLabel.text = "No more guesses. You lost!"
          disableInput()
          retryButton.visible = true
        }
      }
    }
  }


  def updateImageView(): Unit = {
    val imagePath = s"Images/Level${levelnumber}/A${5 - remainingGuesses}.png"
    imageView.image = new Image(imagePath)
  }

  def disableInput(): Unit = {
    charTextField.disable = true
    retryButton.visible = true
  }

  def retry(): Unit = {
    guessedWord = Array.fill(word1.length)('*')
    guessedChars = ""
    remainingGuesses = 5
    wordLabel.text = "Guess the word:"
    wordGuessing.text = guessedWord.mkString
    GuessLeft.text = s"Guesses left: $remainingGuesses"
    charTextField.disable = false
    retryButton.visible = false
    imageView.image = new Image(s"Images/Level${levelnumber}/A0.png")
  }

  def getLevel(): Unit = {
    MainApp.showLevel()
  }
}
