package edu.holycross.shot.virgapes

/** Association of a syllabified text with a
* corresponding series of neumes expressed as Strings.
*
* @param textString Syllabified text, with hyphen separating
* syllables.
* @param neume Neume.
*
*/
case class PairedNeume(textString: String, neume: Neume) {

  //require(textString.split("-").size == neumeString.split(" ").size, "StringPair: unequal syllables in " + textString + " and " + neumeString)


  def interleave = {

  }
}
