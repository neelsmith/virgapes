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



  def align(neumes: Vector[Neume], corpus: Corpus): Vector[PairedSyllable] = {
    Vector.empty[PairedSyllable]
  }

}
