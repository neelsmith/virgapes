package edu.holycross.shot.virgapes
import edu.holycross.shot.cite._
import edu.holycross.shot.mid.validator._
import scala.scalajs.js.annotation._


/** An orthographic system for neumes encoded in the
* Virgapes encoding, registered to a specific text or set
* of texts identified by CtsUrn.
*
* @param domain A set of one or more texts (depending
* on the hierarchical level of domain) identified by a CtsUrn.
*/
@JSExportTopLevel("VirgapesSyllables")  case class VirgapesSyllables() extends MidOrthography {

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

  /** Tokenize a String.
  *
  * @param s String to tokenize.
  */
  def tokenizeString(s: String): Vector[MidToken] = {
    val tokens = s.split("\\s+").filter(_.nonEmpty)
    val pairs = for (t <- tokens) yield {
      if (validString(t)) {
        MidToken(t,Some(NeumeSyllableToken))
      } else {
        MidToken(t,None)
      }
    }
    pairs.toVector
  }
}
