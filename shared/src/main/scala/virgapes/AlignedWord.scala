package edu.holycross.shot.virgapes

/** Association of a syllabified text with a
* corresponding series of neumes expressed as Strings.
*
* @param textString Syllabified text, with hyphen separating
* syllables.
* @param neume Neume.
*
*/
case class AlignedWord(syllables : Vector[PairedSyllable]) {

  def text: String = {
    syllables.map(_.textString).mkString("-")
  }

  def interleave = {

  }
}
