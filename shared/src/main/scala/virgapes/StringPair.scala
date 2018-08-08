package edu.holycross.shot.virgapes

/** Association of a syllabified text with a
* corresponding series of neumes expressed as Strings.
*
* @param textString Syllabified text, with hyphen separating
* syllables.
* @param neumeString String representing sequence of neumes as space-separated Strings.
*
*/
case class StringPair(textString: String, neumeString: String) {

  require(textString.split("-").size == neumeString.split(" ").size, "StringPair: unequal syllables in " + textString + " and " + neumeString)


  def interleave = {
    
  }
}
