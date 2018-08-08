package edu.holycross.shot.virgapes
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.mid.latinmodel.{LexicalToken => Lex, _}
import edu.holycross.shot.latin._

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
*/
object Aligner {



  /** Create a Vector of  syllabified words from
  * a Corpus of text in XML following MID conventions.
  * Each word is represented as a Vector
  * of syllabic strings, so this function returns
  * a Vector[Vector[String]].
  *
  * @param c Corpus to syllabify.
  */
  def syllabifyMidXml(c: Corpus, alphabet: LatinAlphabet  = edu.holycross.shot.latin.Latin23Alphabet
      ): Vector[Vector[String]] = {
    val tkns = LatinTeiReader.fromCorpus(c)
    val diplomaticTokens = tkns.filter(_.analysis.lexicalCategory == Lex).map(_.readWithDiplomatic)
    val diplomaticLC  = diplomaticTokens.map(_.text.toLowerCase).map(_.replaceAll("v", "u"))

    val syllables = for (diplToken <- diplomaticLC) yield {
      val latinString = LatinString(diplToken, alphabet)
      latinString.syllabify
    }
    syllables
  }


  /** Recursively process vector of words.
  */
  def alignTokens(
    syllabifiedWords : Vector[Vector[String]],
    syllabifiedNeumes: Vector[Syllable],
    syllableIndex : Int = 0,
    pairings: Vector[Vector[PairedSyllable]] = Vector.empty) : Unit = { //: Vector[Vector[PairedSyllable]] = {

    if (syllabifiedWords.isEmpty) {
      println("All done! After " + syllableIndex + " syllables out of " + syllabifiedNeumes.size)
      println(pairings)

    } else {
      val wrd = syllabifiedWords.head
      val total = syllableIndex + wrd.size

      //print(wrd.mkString("-") + ", " + syllableIndex + "-" + total)
      if (syllabifiedNeumes.size >= total) {
        val relevant = syllabifiedNeumes.slice(syllableIndex, total)
        println("Sliced " + relevant)
        val zipped = wrd.zip(relevant)
        for (z <- zipped) {
          println(z._1 + ", " + z._2)
          val paired = PairedSyllable(z._1, z._2)

        }

        //zipped.map(PairedSyllable(_._1, _._2 ))
        //val newPair = PairedSyllable(wrd.mkString("-"), relevant)

        //alignTokens(syllabifiedWords.tail, syllabifiedNeumes, total, pairings ::: newPair)
        alignTokens(syllabifiedWords.tail, syllabifiedNeumes, total, pairings)

      } else {
        println("\nRan out of neumes!")
        println(pairings)
      }

    }
  }

  /** Pair syllables in a Latin text with neumes
  * for the corresponding syllable.
  * @param neumeSyllables Vector of Syllables of neumes to align with text.
  * @param corpus Text corpus to align with neumes.
  */
  def alignXml(neumeSyllables: Vector[Syllable], corpus: Corpus): Vector[Vector[PairedSyllable]] = {
    val textSyllables = syllabifyMidXml(corpus).map(_.mkString("-"))
    //alignTokens(textSyllables, neumeSyllables)

    if (textSyllables.size != neumeSyllables.size) {
      println("Aligner: unequal number of syllables in text and neumes")
      println("Number text syllables:  " + textSyllables.size)
      println("Number neume syllables:  " + neumeSyllables.size)
      throw new Exception("Aligner: unequal number of syllables in text and neumes.")
    } else {
      for ((ts, count) <- textSyllables.zipWithIndex) {
        println(ts + " == " + neumeSyllables(count))
      }
      //println(textSyllables)
      //println(neumeSyllables)
      //val zipped = textSyllables.zip(neumeSyllables)

      //for (z <- zipped) {
      //  println(z._1 + ", " + z._2)
    //  }//

    }
    Vector.empty[Vector[PairedSyllable]]
  }

}
