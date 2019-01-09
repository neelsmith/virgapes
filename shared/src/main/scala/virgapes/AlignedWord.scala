package edu.holycross.shot.virgapes
import scala.scalajs.js.annotation._


/** Association of a syllabified text with a
* corresponding series of neumes expressed as Strings.
*
* @param textString Syllabified text, with hyphen separating
* syllables.
* @param neume Neume.
*
*/
@JSExportTopLevel("AlignedWord") case class AlignedWord(syllables : Vector[PairedSyllable]) {

  def word : String = {
    syllables.map(_.textString).mkString("")
  }
  def text: String = {
    syllables.map(_.textString).mkString("-")
  }
  def neumes : String = {
    val syllStrs = syllables.map(_.syllable.toString)
    //println("From " + syllables + ", got " + syllStrs)
    syllables.map(_.syllable.toString).mkString(" ")
  }

  def interleave(separator: String = "\n") = {
    val interleaved = syllables.map(s =>  s"${s.textString} ${s.syllable}")
    interleaved.mkString(separator)
  }
}
