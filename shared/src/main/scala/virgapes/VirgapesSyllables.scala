package edu.holycross.shot.virgapes
import edu.holycross.shot.cite._
import edu.holycross.shot.mid.validator._
import edu.holycross.shot.ohco2._
import scala.scalajs.js.annotation._


/** An orthographic system for neumes encoded in the
* Virgapes encoding, registered to a specific text or set
* of texts identified by CtsUrn.
*
* @param domain A set of one or more texts (depending
* on the hierarchical level of domain) identified by a CtsUrn.
*/
@JSExportTopLevel("VirgapesSyllables")  object VirgapesSyllables extends MidOrthography {

  /** Name of orthographic system implementing MidOrthogaphy.*/
  def orthography = "Virgapes syllabic reading"

  // named code points
  /** Tab character.*/
  val tab = 0x9
  /** Newline character.*/
  val nl = 0xA
  /** Carriage return character.*/
  val cr = 0xD
  /** Space character.*/
  val space = 0x20
  /** Collection of all whitespace characters.*/
  val whiteSpace = Vector(space, tab, nl, cr)

  /** Period character.*/
  val period = 0x2e
  /** Hyphen character.*/
  val hyphen = 0x2d
  /** Digits 0 to 9.*/
  val digits = (0x30 to 0x39).toVector

  /** All valid code points. */
  val cpList:  Vector[Int] =  digits :+ space :+ period :+ hyphen


  /** True if cp is a valid code point in the
  * Virgapes encoding.
  *
  * @param cp Codepoint to check.
  */
  def validCP(cp: Int): Boolean = {
    cpList.contains(cp)
  }

  /** Categories of tokens recognized by this orthography.*/
  def tokenCategories = {
    Vector(NeumeSyllableToken)
  }

  def tokenizeNode(n: CitableNode): Vector[MidToken] = {

    val syllables = n.text.split("\\s+").filter(_.nonEmpty)
    val tokenized = for (syllable <- syllables.zipWithIndex) yield {
      val newPassage = n.urn.passageComponent + "." + syllable._2
      val newVersion = n.urn.addVersion(n.urn.versionOption.getOrElse("") + "_sylls")
      val newUrn = CtsUrn(newVersion.dropPassage.toString + newPassage)
      val trimmed = syllable._1.trim
      MidToken(newUrn, trimmed, Some(NeumeSyllableToken))
    }
    tokenized.toVector
  }

}
