package de.tuberlin.snet.prog2.ue10.consoles

import java.time.LocalDate

object TierHierarchie {
  def main(args: Array[String]): Unit = {
    val duck:Duck = new Duck("Gustav")
    duck.fly()
    duck.swim()
    duck.makeNoise()
    println(duck.name)
    
    val man:Man = new Man("Hans")
    man.isColleague()
    man.isFriend()
    
    val dog:Dog = new Dog("Bruno")
    dog.makeNoise()
    dog.isFriend()
  }
}

trait Colleague {
  val name:String
  
  def isColleague()
}

trait Friend {
  val name:String
  
  def isFriend()
}

class Human(val name:String) extends Friend with Colleague{
  override def isFriend() = println(s"Your friend is: $name")
  override def isColleague() = println(s"Your colleague is: $name")
}

class Man(override val name:String) extends Human(name) {
  
  override def isFriend() = println(s"Your friend is: $name")
  override def isColleague() = println(s"Your colleague is: $name")
  
}

class Woman(override val name:String) extends Human(name) {
  
  override def isFriend() = println(s"Your friend is: $name")
  override def isColleague() = println(s"Your colleague is: $name")
}

abstract class Animal {
  def makeNoise()
}

class Dog(override val name:String) extends Animal with Friend {
  override def makeNoise() = println("Woof")
  override def isFriend() = println(s"Your friend is: $name")
}

class Cat(val name:String) extends Animal {
  override def makeNoise() = println("Meow")
}

abstract class Bird extends Animal {
  val name:String
}

trait Flying extends Animal {
  //abstract val
  val flyMessage:String
  
  def fly()
}

trait Swimming extends Animal {
  //abstract val
  val swimmMessage:String
  
  def swim()
}

class FrigateBird(override val name:String) extends Bird with Flying {
  override def fly() = println(flyMessage)
  override def makeNoise() = println("Im a FrigateBird")
  override val flyMessage = "FlyFlyFly"
}

class Duck(override val name:String) extends Bird with Flying with Swimming {
  override def fly() = println(flyMessage)
  override def swim() = println(swimmMessage)
  override def makeNoise() = println("Im a Duck")
  override val swimmMessage = "SwimSwimSwim"
  override val flyMessage = "FlyFlyFly"
}

class Ostrich(override val name:String) extends Bird {
  override def makeNoise() = println("Im an Ostrich")
}

class Penguin(override val name:String) extends Bird with Swimming {
  override def swim() = println(swimmMessage)
  override def makeNoise() = println("Im a Penguin")
  override val swimmMessage = "SwimSwimSwim"
}