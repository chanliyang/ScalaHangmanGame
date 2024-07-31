package ch.makery.address.view

import ch.makery.address.MainApp
import javafx.fxml.FXML
import javafx.scene.control.{Label, TextField}
import scalafxml.core.macros.sfxml

@sfxml
class GameController {

  private val word1 = "tree"

  def getLevel(): Unit = {
    // Go back to level page
    MainApp.showLevel()
  }

  @FXML
  private var wordLabel: Label = _
  @FXML
  private var charTextField: TextField = _

  def initialize(): Unit = {
    wordLabel.setText("Guess the word:")
  }

  @FXML
  def submit(): Unit = {
    if (charTextField != null && wordLabel != null) {
      val enteredChar = charTextField.getText().charAt(0)
      if (word1.contains(enteredChar)) {
        wordLabel.setText(s"The character '$enteredChar' is in the word!")
      } else {
        wordLabel.setText(s"The character '$enteredChar' is not in the word.")
      }
      charTextField.clear()
    } else {
      println("charTextField or wordLabel is not initialized")
    }
  }
}
