package edu.holycross.shot.virgapes


/** A class representing a single neume.
*
* @param pitches Number of pitches in this neume.
* @param neume Identifier for this neume within set of
* neumes having this number of pitches.
* @param episema Syllable marked with episema, if any.
* @param liquescence Whether or not this neume has liquescence.
*/
case class Neume(pitches: Int, neume: Int, episema: Int, liquescence: Boolean) {
  require(validNeume)

  def validNeume: Boolean = {
    require((0 to 4).toVector.contains(pitches))
    require(neume > 0)
    require((0 to 2).toVector.contains(episema))
    require(episema <= pitches, s"Episema (${episema}) cannot be greater than total number of pitches (${pitches})")
    true
  }
}

/** Factory object for building [[Neume]]s.
*/
object Neume {


  /** Build a [[Neume]] from a dot-delimited string.
  *
  * @param s String with four integers separated by periods.
  */
  def apply(s: String): Neume = {
    def parts = s.split("\\.").toVector
    assert(parts.size == 4, "Wrong number of components in " + parts + s" (${parts.size})")

    Neume(parts.map(_.toInt))
  }


  /** Build a [[Neume]] from a vector of four integers.
  *
  *  @param v Vector of four integers encoding number of syllables,
  * neume ID, episema, and liquescence, respectively.
  */
  def apply(v: Vector[Int]): Neume = {
    require(v.size == 4, "Wrong number of components in " + v + s" (v.size)")
    val liquescence = v(3) > 0
    Neume(v(0), v(1), v(2), liquescence)
  }
}
