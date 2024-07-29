package ch.makery.address

import ch.makery.address.MainApp.loader
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafxml.core.{FXMLLoader, FXMLView, NoDependencyResolver}
import scalafx.scene.Scene
import scalafx.scene.layout.BorderPane

object MainApp extends JFXApp {

  val rootResource = getClass.getResource("/ch/makery/address/view/Main.fxml")
  val root = FXMLView(rootResource, NoDependencyResolver)

  val primaryStage: PrimaryStage = new PrimaryStage {
    title.value = "Hangman Game"
    scene = new Scene(root.asInstanceOf[BorderPane])
  }

  def showPersonOverview() = {
    val resource = getClass.getResource("view/PersonOverview.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  stage = primaryStage
}
