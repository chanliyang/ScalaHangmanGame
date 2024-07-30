package ch.makery.address.view

import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml


@sfxml
class MainController(){

  def getStart(): Unit={
    MainApp.showGame()
  }

  def getWelcome(): Unit={
    MainApp.showMain()
  }
}