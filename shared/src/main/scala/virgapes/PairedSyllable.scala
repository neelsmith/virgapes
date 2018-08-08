package edu.holycross.shot.virgapes

/** Association of a syllabified text with a
* corresponding series of neumes expressed as Strings.
*
* @param textString Syllabified text, with hyphen separating
* syllables.
* @param neume Neume.
*
*/
case class PairedSyllable(textString: String, syllable: Syllable) {


  require(textString.split("-").size == syllable.size, "PairedSyllable: unequal number of syllables in " + textString + " and " + syllable)


  def interleave = {

  }
}
