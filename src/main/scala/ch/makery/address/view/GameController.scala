package ch.makery.address.view

import scalafx.event.ActionEvent
import scalafx.scene.control.{Label, TextField}
import ch.makery.address.model.Hangman
import scalafxml.core.macros.sfxml

@sfxml
class GameController(
                      private val wordLabel: Label,
                      private val guessField: TextField,
                      private val messageLabel: Label
                    ) {
  private val hangman = new Hangman("SCALA")

  def initialize(): Unit = {
    wordLabel.setText(hangman.getGuessedWord)
  }

  def handleGuess(action: ActionEvent): Unit = {
    val guess = guessField.getText().charAt(0).toUpper
    if (hangman.guess(guess)) {
      messageLabel.setText(s"Good guess! $guess is in the word.")
    } else {
      messageLabel.setText(s"Sorry, $guess is not in the word. Attempts left: ${hangman.getAttemptsLeft}")
    }
    wordLabel.setText(hangman.getGuessedWord)
    guessField.clear()

    if (hangman.isGameOver) {
      messageLabel.setText("Game Over! The word was: " + hangman.word)
      guessField.setDisable(true)
    }
  }
}
