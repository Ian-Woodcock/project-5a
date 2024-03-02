/*
  Project 5a step 2
  Author: Ian Woodcock
  Date: 3/1/2024
*/


import scala.io.StdIn.readLine
import scala.util.Random

class SixLittle{
//setup arrays 
  var words = Array[String]()
  var hints = Array[String]()
  var tokens = Array[String]()

  //ask for six pairs of strings
  def ask(): Unit = {
    while (words.length < 6) {
      println("Enter a word that is at least 4 characters: ")
      val word = readLine()
      if(word.length >= 4){
        println("Enter a hint for this word: ")
        val hint = readLine()
        words :+= word
        hints :+= hint
      }
      else{
        println("Word is too short, try again")
      }    
    }
  }
  //break words and shuffle tokens
  def prepare(): Unit = {
    
    words.foreach { word =>
      val middle = (word.length / 2 + (word.length % 2))
      val (firstHalf, secondHalf) = word.splitAt(middle)
      tokens :+= firstHalf.toUpperCase
      tokens :+= secondHalf.toUpperCase
    }
    tokens = Random.shuffle(tokens.toList).toArray    
  }

  //display info
  def display(): Unit = {
    println("Six Little Words (Scala)")
    println("\nTokens:")
    tokens.grouped(4).foreach { group =>
      println(group.mkString("\t"))
    }
    println("\n\nHints:")
    hints.foreach(println)
    
    println("\n\nAnswer Key:")
    words.grouped(3).foreach{ group =>
      println(group.mkString("\t"))
    }
  }
  //run program
  def run(): Unit = {
    words = Array.empty
    hints = Array.empty
    tokens = Array.empty
    ask()
    prepare()
    display()
  }
}

//main to actually run it
object Main {
  def main(args: Array[String]): Unit = {
    var Game = new SixLittle
    Game.run()
  }
}

/*
 rescources used:
 docs.scala-lang.org
 baeldung.com/scala
 tutorialspoint.com/scala
*/
