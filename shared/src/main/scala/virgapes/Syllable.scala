package edu.holycross.shot.virgapes
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._

/** A class representing an ordered sequence of [[Neume]]s
* on a single syllable of text.
*
* @param neumes Vector of [[Neume]]s on a single syllable of text.
*/
case class Syllable(neumes: Vector[Neume]) {
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
object Syllable {

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

  def apply(n: CitableNode): Vector[Syllable] = {
    Syllable(n.text)
  }
}
