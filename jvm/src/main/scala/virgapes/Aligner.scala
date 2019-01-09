package edu.holycross.shot.virgapes
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.mid.latinmodel.{LexicalToken => Lex, _}
import edu.holycross.shot.latin._

import scala.scalajs.js
import scala.scalajs.js.annotation._

/** Object for aligning texts and neumes from
* different kinds of sources, and creating
* Vectors of [[PairedSyllable]]s.
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
    pairings: Vector[Vector[PairedSyllable]] = Vector.empty) :  Vector[Vector[PairedSyllable]] = {

    if (syllabifiedWords.isEmpty) {
      pairings

    } else {
      val wrd = syllabifiedWords.head
      val total = syllableIndex + wrd.size

      if (syllabifiedNeumes.size >= total) {
        val relevant = syllabifiedNeumes.slice(syllableIndex, total)
        val zipped = wrd.zip(relevant)
        val pairs = for (z <- zipped) yield {
          PairedSyllable(z._1, z._2)
        }
        val updated = pairings :+ pairs
        alignTokens(syllabifiedWords.tail, syllabifiedNeumes, total, updated)

      } else {
        println("\nRan out of neumes!")
        println(pairings )
        pairings
      }
    }
  }

  /** Pair syllables in a Latin text with neumes
  * for the corresponding syllable.
  * @param neumeSyllables Vector of Syllables of neumes to align with text.
  * @param corpus Text corpus to align with neumes.
  */
  def alignXml(neumeSyllables: Vector[Syllable], corpus: Corpus): Vector[Vector[PairedSyllable]] = {
    val wordSyllables = syllabifyMidXml(corpus)//.map(_.mkString("-"))
    //alignTokens(textSyllables, neumeSyllables)
    val syllCounts  = wordSyllables.map(_.size).sum

    if (syllCounts != neumeSyllables.size) {
      println("Aligner: unequal number of syllables in text and neumes")
      println("Number text syllables:  " + wordSyllables.size)
      println("Number neume syllables:  " + neumeSyllables.size)
      throw new Exception("Aligner: unequal number of syllables in text and neumes.")
    } else {
      for ((ts, count) <- wordSyllables.zipWithIndex) {
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

  def alignMidCorpora(neumes: Corpus, texts: Corpus) = { //: Vector[Vector[PairedSyllable]] = {
    def syllabifiedWords = syllabifyMidXml(texts)
    def syllabifiedNeumes = Syllabifier.fromXmlCorpus(neumes)
    alignTokens(syllabifiedWords, syllabifiedNeumes)
  }
}
