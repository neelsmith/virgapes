package edu.holycross.shot.virgapes

/** Taxonomy of neumes.  Specific neumes are used
* for a given number of syllables, and have a name.
*/
sealed trait NeumeType {
  /** Number of pitches appropriate for this neueme.*/
  def pitches: Int
  /** Name of this neume. */
  def name: String
}

//Significative letters
final case object SignificativeA extends NeumeType {
  def pitches: Int = { 0 }
  def name: String = "a"
}
final case object SignificativeB extends NeumeType {
  def pitches: Int = { 0 }
  def name: String = "b"
}
final case object SignificativeC extends NeumeType {
  def pitches: Int = { 0 }
  def name: String = "c"
}
final case object SignificativeE extends NeumeType {
  def pitches: Int = { 0 }
  def name: String = "e"
}
final case object SignificativeF extends NeumeType {
  def pitches: Int = { 0 }
  def name: String = "f"
}

final case object SignificativeI extends NeumeType {
  def pitches: Int = { 0 }
  def name: String = "i"
}
final case object SignificativeK extends NeumeType {
  def pitches: Int = { 0 }
  def name: String = "k"
}
final case object SignificativeL extends NeumeType {
  def pitches: Int = { 0 }
  def name: String = "l"
}
final case object SignificativeM extends NeumeType {
  def pitches: Int = { 0 }
  def name: String = "m"
}
final case object SignificativeP extends NeumeType {
  def pitches: Int = { 0 }
  def name: String = "p"
}
final case object SignificativeS extends NeumeType {
  def pitches: Int = { 0 }
  def name: String = "s"
}
final case object SignificativeT extends NeumeType {
  def pitches: Int = { 0 }
  def name: String = "t"
}
final case object SignificativeV extends NeumeType {
  def pitches: Int = { 0 }
  def name: String = "v"
}
final case object SignificativeX extends NeumeType {
  def pitches: Int = { 0 }
  def name: String = "x"
}

// One-syllable neume types:
final case object Virga extends NeumeType {
  def pitches: Int = { 1 }
  def name: String = "virga"
}
final case object Pes extends NeumeType  {
  def pitches: Int = { 1 }
  def name: String = "pes"
}
final case object Apostrophe extends NeumeType  {
  def pitches: Int = { 1 }
  def name: String = "apostrophe"
}
final case object Quilisma extends NeumeType  {
  def pitches: Int = { 1 }
  def name: String = "quilisma"
}

// Two-syllable neume types:
final case object Clivis extends NeumeType  {
  def pitches: Int = { 2 }
  def name: String = "clivis"
}
