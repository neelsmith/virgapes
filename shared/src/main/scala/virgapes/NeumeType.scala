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
final case object Punctum extends NeumeType  {
  def pitches: Int = { 1 }
  def name: String = "punctum"
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

final case object Pes extends NeumeType  {
  def pitches: Int = { 2 }
  def name: String = "pes"
}

final case object Distropha extends NeumeType  {
  def pitches: Int = { 2 }
  def name: String = "distropha"
}

final case object Bivirga extends NeumeType  {
  def pitches: Int = { 2 }
  def name: String = "bivirga"
}

final case object PesQuassus extends NeumeType  {
  def pitches: Int = { 2 }
  def name: String = "pes quassus"
}




// Three-syllable neume types:

final case object Porrectus extends NeumeType  {
  def pitches: Int = { 3 }
  def name: String = "porrectus"
}

final case object Torculus extends NeumeType  {
  def pitches: Int = { 3 }
  def name: String = "torculus"
}

final case object Climacus extends NeumeType  {
  def pitches: Int = { 3 }
  def name: String = "climacus"
}

final case object Scandicus extends NeumeType  {
  def pitches: Int = { 3 }
  def name: String = "scandicus"
}

final case object Tristropha extends NeumeType  {
  def pitches: Int = { 3 }
  def name: String = "tristropha"
}

final case object Trisvirga extends NeumeType  {
  def pitches: Int = { 3 }
  def name: String = "trisvirga"
}

final case object Trigon extends NeumeType  {
  def pitches: Int = { 3 }
  def name: String = "trigon"
}

// Four-syllable neume types:
final case object PorrectusFlexus extends NeumeType  {
  def pitches: Int = { 4 }
  def name: String = "porrectus flexus"
}
final case object PesSubBipunctis extends NeumeType  {
  def pitches: Int = { 4 }
  def name: String = "pes subbipunctis"
}
final case object ScandicusFlexus extends NeumeType  {
  def pitches: Int = { 4 }
  def name: String = "scandicus flexus"
}
final case object TorculusResupinus extends NeumeType  {
  def pitches: Int = { 4 }
  def name: String = "torculus resupinus"
}
