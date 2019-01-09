package edu.holycross.shot.virgapes
import edu.holycross.shot.cite._
import edu.holycross.shot.mid.validator._

/** An orthographic system for neumes encoded in the
* Virgapes encoding, registered to a specific text or set
* of texts identified by CtsUrn.
*
* @param domain A set of one or more texts (depending
* on the hierarchical level of domain) identified by a CtsUrn.
*/
case class Virgapes() extends MidOrthography {

  /** Name of orthographic system implementing MidOrthogaphy.*/
  def orthography = "Virgapes"

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
    Vector(NeumeToken, PunctuationToken)
  }

  /** Tokenize a String.
  *
  * @param s String to tokenize.
  */
  def tokenizeString(s: String): Vector[MidToken] = {

    val expandHyphens = s.replaceAll("-", " - ")
    val tokens = expandHyphens.split("\\s+").filter(_.nonEmpty)
    val pairs = for (t <- tokens) yield {
      if (t == "-") {
        MidToken(t,Some(PunctuationToken))
      } else if (validString(t)) {
        val parts = t.split("\\.")
        if (parts.size == 4) {
          MidToken(t,Some(NeumeToken))
        } else {
          MidToken(t,None)
        }

      } else {
        MidToken(t,None)
      }
    }
    pairs.toVector
  }
}
