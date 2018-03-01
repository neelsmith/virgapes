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
