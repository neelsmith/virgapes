package edu.holycross.shot.virgapes
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._

import scala.scalajs.js
import scala.scalajs.js.annotation._

/** A class representing an ordered sequence of [[Neume]]s
* on a single syllable of text.
*
* @param neumes Vector of [[Neume]]s on a single syllable of text.
*/
@JSExportAll case class Syllable(neumes: Vector[Neume]) {
  require (neumes.size > 0, "Cannot create syllable from empty vector.")
  /** Number of neumes on this syllable.
  */
  def size: Int = {
    neumes.size
  }
}

/** Factory object for building Vectors of [[Syllable]]s from strings.
*
* White space separates syllables.  Hyphens separate neumes for
* a single syllable.
*/
object Syllabifier {

  /** Build a Vector of [[Syllable]]s from a string value.
  *
  * @param s String with neume values separated by hyphens.
  */
  def apply(s: String): Vector[Syllable] = {

    val syllableStrings = s.split("\\s+").filterNot(_.isEmpty).toVector

    val syllables = for (syll <- syllableStrings) yield {
      def neumeStrings = syll.split("-").toVector
      require (neumeStrings.size > 0, "Cannot create syllable from empty string.")
      val neumes = neumeStrings.map(Neume(_))
      Syllable(neumes)
    }
    syllables.toVector
  }

  /** Build a Vector of [[Syllable]]s from an OHCO2 CitableNode.
  *
  * @param n CitableNode with text content consiting of neumes encoded in virgapes notation.
  */
  def apply(n: CitableNode): Vector[Syllable] = {
    Syllabifier(n.text)
  }
}
