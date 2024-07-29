package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.layout.VBox
import scalafx.stage.Stage
import scalafxml.core.{FXMLView, NoDependencyResolver}

class MainController {

  def handleStartGame(action: ActionEvent): Unit = {
    try {
      val resource = getClass.getResource("/ch/makery/address/view/Game.fxml")
      val root = FXMLView(resource, NoDependencyResolver)
      val scene = new Scene(root.asInstanceOf[VBox])
      val stage = new Stage() {
        title = "Hangman Game"
        scene = scene
      }
      stage.show()
    } catch {
      case e: Exception =>
        e.printStackTrace()
        val alert = new Alert(AlertType.Error) {
          initOwner(MainApp.primaryStage)
          title = "Error"
          headerText = "Could not start game"
          contentText = "An error occurred while trying to start the game."
        }
        alert.showAndWait()
    }
  }
}
