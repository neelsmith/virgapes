package edu.holycross.shot.virgapes
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.mid.latinmodel._
import edu.holycross.shot.latin._

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
*/
object Aligner {



  /** Create a Vector of  syllabified words from
  * a Corpus.  Each word is represented as a Vector
  * of syllabic strings, so this function returns
  * a Vector[Vector[String]].
  *
  * @param c Corpus to syllabify.
  */
  def textSyllables(c: Corpus): Vector[Vector[String]] = {
    val tkns = LatinTeiReader.fromCorpus(c)
    val diplomaticTokens = tkns.map(_.readWithDiplomatic)
    val diplomaticLC  = diplomaticTokens.map(_.text.toLowerCase).map(_.replaceAll("v", "u"))

    val alphabet = edu.holycross.shot.latin.Latin23Alphabet
    val syllables = for (diplToken <- diplomaticLC) yield {
      val latinString = LatinString(diplToken, alphabet)
      latinString.syllabify
    }
    syllables
  }



  def align(neumes: Vector[Neume], corpus: Corpus): Vector[PairedNeume] = {
    Vector.empty[PairedNeume]
  }

}
