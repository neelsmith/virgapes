package edu.holycross.shot.virgapes
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._



/** Factory object for building Vectors of virgapes [[Syllable]]s from various kinds of sources.
*
* In the String serialization, white space separates syllables.
* Hyphens separate neumes for a single syllable.
*/
object Syllabifier {


  /** Build a Vector of [[Syllable]]s from the text
  * nodes of an XML String.
  *
  * @param xml String of well-formed XML with text content
  * following conventions for representing syllableStrings
  * of neumes.
  */

  /*
  def fromXml(xml: String) : Vector[Syllable] = {
    val plainText = edu.holycross.shot.mid.latinmodel.collectText(xml)
    Syllabifier(plainText)
  }
*/
  /** Build a Vector of [[Syllable]]s from a string value.
  *
  * @param s String with neume values separated by hyphens.
  */

  /*
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
*/
  /** Build a Vector of [[Syllable]]s from an OHCO2 CitableNode.
  *
  * @param n CitableNode with text content consiting of neumes encoded in virgapes notation.

  def apply(n: CitableNode): Vector[Syllable] = {
    Syllabifier(n.text)
  }
  */
  /** Build a Vector of [[Syllable]]s from an OHCO2
  * Corpus of XML documents, where text nodes of the
  * follow conventions for representing strings
  * of neumes.
  *
  * @param xml String of well-formed XML with text content
  * following conventions for representing syllableStrings
  * of neumes.

  def fromXmlCorpus(c: Corpus): Vector[Syllable] = {

    c.nodes.map( n => Syllabifier.fromXml(n.text)).flatten
  }  */
}
