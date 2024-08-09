package ch.makery.address
import ch.makery.address.view.GameController
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes._
import scalafxml.core.{FXMLLoader, FXMLView, NoDependencyResolver}
import javafx.{scene => jfxs}
import scalafx.scene.image.Image
import scalafx.scene.layout.AnchorPane




object MainApp extends JFXApp {

  val rootResource = getClass.getResource("view/RootLayout.fxml")
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  loader.load();
  val roots = loader.getRoot[jfxs.layout.BorderPane]
  stage = new PrimaryStage {
    icons += new Image(getClass.getResourceAsStream("/Images/icon.png"))
    title = "Guess the word (Hangman Game)"
    scene = new Scene {
      root = roots


    }
  }


  def showLevel() = {
    val resource = getClass.getResource("view/Level.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }


//  def showGame(word: String, levelNumber: Int): Unit = {
//    println(word)  // checking only
//    println(levelNumber)
//    val resource = getClass.getResource("view/Game.fxml")
//    val loader = new FXMLLoader(resource, NoDependencyResolver)
//    val roots = loader.load[jfxs.layout.AnchorPane]()
//    this.roots.setCenter(roots)
//    val gameController = loader.getController[GameController]
//    gameController.setWord(word)
//    gameController.setLevelNumber(levelNumber)
//
//  }

  def showGame(levelNumber: Int): Unit = {
    val resource = getClass.getResource("view/Game.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    val controller = loader.getController[GameController]
    controller.setLevelNumber(levelNumber)
    controller.initialize()
    this.roots.setCenter(roots)
  }




  def showMain() = {
    val resource = getClass.getResource("view/Main.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }


  def showInstruction() = {
    val resource = getClass.getResource("view/Instruction.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }



  showMain()



}