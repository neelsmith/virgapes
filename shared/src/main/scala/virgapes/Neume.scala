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


  def neumeType(pitchCount: Int, neumeId: Int): Option[NeumeType] = {
    pitchCount match {
      case 1 => neumeId match {
        case 1 => Some(Virga)
        case 2 => Some(Pes)
        case 3 => Some(Apostrophe)
        case 4 => Some(Quilisma)
        case i: Int => {
          println(s"Unrecognized ID ${i} for one-syllable neume.")
          None
        }
      }
      case 2 => neumeId match {
        case 1 => Some(Clivis)
        case i: Int => {
          println(s"Unrecognized ID ${i} for two-syllable neume.")
          None
        }
      }
      case i: Int => None
    }
  }
  /*
  def neumeName(pitches: Int, id: Int): String = {

    pitches match {
      

      case 2 => id match {
        case 1 => "clivis"
        case 2 => "pes"
        case 3 => "distropha"
        case 4 => "bivirga"
        case 5 => "pes quassus"
        case i: Int => s"Unrecognized ID ${i} for two-syllable neume."
      }
      case 3 => id match {
        case 1 => "porrectus"
        case 2 => "torculus"
        case 3 => "climacus"
        case 4 => "scandicus"
        case 5 => "tristropha"
        case 6 => "trivirga"
        case 7 => "trigon"
        case i: Int => s"Unrecognized ID ${i} for three-syllable neume."
      }
      case 4 => id match {
        case 1 => "porrectus flexus"
        case 2 => "pes subbipunctis"
        case 3 => "scandicus flexus"
        case 4 => "torculus resupinus"
        case i: Int => s"Unrecognized ID ${i} for four-syllable neume."
      }
      case _ => {
        s"Neumes with ${pitches} syllables are not supported"
      }
    }
  }
  */

}
