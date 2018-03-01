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

  def neumeType: Option[NeumeType] = {
    Neume.neumeType(pitches, neume)
  }
  /** Provide name for unique neume.
  */
  def name: String = {
    neumeType match {
      case None => s"Could not find type for ID ${neume} with ${pitches} pitch(es)."
      case nt: Some[NeumeType] => nt.get.name
    }
  }

  /**  Validate values for member elements.
  */
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


  /** Look up name of neume for given pitch and id combination.
  *
  * @param pitches Number of pitches.
  * @param id Unique identifier for neueme of given pitch size.
  */


  /** Determine type of neume for given pitch count and neume ID.
  * @param pitchCount Number of pitches in this neume.
  * @param neumeId Unique ID within given number of pitches.
  */
  def neumeType(pitchCount: Int, neumeId: Int): Option[NeumeType] = {
    pitchCount match {
      case 1 => neumeId match {
        case 1 => Some(Virga)
        case 2 => Some(Punctum)
        case 3 => Some(Apostrophe)
        case 4 => Some(Quilisma)
        case i: Int => {
          println(s"Unrecognized ID ${i} for one-syllable neume.")
          None
        }
      }
      case 2 => neumeId match {
        case 1 => Some(Clivis)
        case 2 => Some(Pes)
        case 3 => Some(Distropha)
        case 4 => Some(Bivirga)
        case 5 => Some(PesQuassus)
        case i: Int => {
          println(s"Unrecognized ID ${i} for two-syllable neume.")
          None
        }
      }

      case 3 => neumeId match {
        case i: Int => {
          println(s"Unrecognized ID ${i} for three-syllable neume.")
          None
        }
      }
      case 4  => neumeId match {
        case i: Int => {
          println(s"Unrecognized ID ${i} for four-syllable neume.")
          None
        }
      }

      case 0 => neumeId match {
        case i: Int => {
          println(s"Unrecognized ID ${i} for significative letter.")
          None
        }
      }
    }
  }
}
