package de.tuberlin.snet.prog2.ue10.consoles

import java.time.LocalDate

object GamerService {
  def main(args: Array[String]): Unit = {
    val ps = new Console("Sony", "PlayStation 5",
      LocalDate.of(2017, 8, 23), None,
      List(new BD), new UHD4K)
    val atari = new Console("Atari", "2600",
      LocalDate.of(1997, 10, 1), None,
      List(new Cartridge), new QHD)
    val dieGeilsteKonsole = new Console("Only", "Deine Mutter v19",
      LocalDate.of(2012, 5, 6), None,
      List(new VHS), new HD)
    //    println(ps.toString());
    //    println("-----------------------")
    //    println(atari.toString());
    //    println("-----------------------")
    //    println(dieGeilsteKonsole.toString());

    var liste : List[Console] = List(ps,atari,dieGeilsteKonsole).sortWith(_.aufloesung.pixel < _.aufloesung.pixel)
//    println(liste)

        
        
        val battlefield0 = Game.newGame("BattleField 0", "EA", List(ps))
        val cod = Game.newGame("Call of Duty", "Activison", List(ps))
        val battlefield1 = Game.newGame("BattleField 0", "EA", List(ps,atari))
        val battlefield2 = Game.newGame("BattleField 0", "Meine Oma", List(dieGeilsteKonsole))
        println(Game.liste)
//        println(battlefield0)
//        println(battlefield0.isSupported(dieGeilsteKonsole))
        

  }
}
abstract class medien {
}
class BD extends medien {}
class CD extends medien {}
class VHS extends medien {}
class Cartridge extends medien {}

abstract class Pixel {
  val pixel: Int
  override def toString = s"Pixel: $pixel px"
}
class HD(val pixel: Int = 720) extends Pixel {}
class FHD(val pixel: Int = 1080) extends Pixel {}
class QHD(val pixel: Int = 1440) extends Pixel {}
class UHD4K(val pixel: Int = 2160) extends Pixel {}

class Console(val hersteller: String, val name: String, val datum: LocalDate, val wifi: Option[String] = Option(null), val medienFormate: List[medien], val aufloesung: Pixel) {
  override def toString = s"\nHersteller: $hersteller Name: $name Datum: $datum WIFI: $wifi Medienformate: $medienFormate Aufloesung: $aufloesung"
}

class Game(val name: String, val hersteller: String, var konsolen: List[Console]) {
  def isSupported(console: Console): Boolean = if (konsolen.contains(console)) true else false
  override def toString = s"Name: $name Hersteller: $hersteller Konsolen: $konsolen"
}

object Game {
  var liste: List[Game] = List()

  def newGame(name: String, hersteller: String, konsolen: List[Console]): Game = {

    var newGame: Game = new Game(name, hersteller, konsolen)

    var flag: Boolean = false
    var index: Int = -1

    for (x <- 0 until liste.length) {

      if ((liste(x).name == newGame.name) && (liste(x).hersteller == newGame.hersteller)) {
        index = x
        flag = true
        
        for (y <- 0 until newGame.konsolen.length) {
          if(!liste(x).konsolen.contains(newGame.konsolen(y))) {
            liste(x).konsolen = liste(x).konsolen :+ newGame.konsolen(y)
          }
        }
      }
    }

    if (!flag) {
      liste = newGame :: liste
      newGame
    } else {
      liste(index)
    }
  }
  
  def printGames() = {
    for (x <- 0 until liste.length) {
        println(liste(x).name);
    }
  }
}