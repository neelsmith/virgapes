package edu.holycross.shot.virgapes


import scala.scalajs.js
import scala.scalajs.js.annotation._

/** A class representing a single neume.
*
* @param pitches Number of pitches in this neume.
* @param neume Identifier for this neume within set of
* neumes having this number of pitches.
* @param episema Syllable marked with episema, if any.
* @param liquescence Whether or not this neume has liquescence.
*/
@JSExportAll case class Neume(pitches: Int, neume: Int, episema: Int, liquescence: Int) {
  require(validNeume)


  /** Serialize to Virgapes encoding. */
  override def toString: String = {
    s"${pitches}.${neume}.${episema}.${liquescence}"
  }


  /** Determine type of neume from its pitch count and neume ID, or
  * None if invalid combination of ID and pitch count. */
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


  /** Compose markdown string for link to glyph for this neume.
  * Assumed that neume glyphs are .png files with name matching
  * String encoding of the neueme.
  *
  * @param urlBase
  */
  def mdGlyph(urlBase: String = Neume.defaultGlyphBase): String = {
    "![" + this.toString + "](" + urlBase +  this.toString + ".png)"
  }


  /** Compose HTML string for link to glyph for this neume.
  * Assumed that neume glyphs are .png files with name matching
  * String encoding of the neueme.
  *
  * @param width Width for displayed image.
  * @param urlBase
  */
  def htmlGlyph(width: Int = 20, urlBase: String = Neume.defaultGlyphBase): String = {
     "<img src=\"" +  urlBase +  this.toString + ".png\" width=\"" + width + "\"/>"
  }

  /**  Validate values for member elements.
  */
  def validNeume: Boolean = {
    require((0 to 4).toVector.contains(pitches),s"Number of pitches must in range 0..4 (${pitches})")
    require((0 to 2).toVector.contains(episema), s"Value episema must be in range 0..2 (${episema})")
    require(episema <= pitches, s"Episema (${episema}) cannot be greater than total number of pitches (${pitches})")

    pitches match {
      case 0 => {
        require( (1 to 14).toVector.contains(neume), s"Invalid ID ${neume} for significative letter.")
        true
      }
      case 1 => {
        require( (1 to 4).toVector.contains(neume), s"Invalid ID ${neume} for neume with one syllable.")
        true
      }
      case 2 => {
        require( (1 to 5).toVector.contains(neume), s"Invalid ID ${neume} for neume with two syllables.")
        true
      }
      case 3 => {
        require( (1 to 7).toVector.contains(neume), s"Invalid ID ${neume} for neume with three syllables.")
        true
      }
      case 4 => {
        require( (1 to 7).toVector.contains(neume), s"Invalid ID ${neume} for neume with four syllables.")
        true
      }
    }
  }
}

/** Factory object for building [[Neume]]s.
*/
object Neume {

  val defaultGlyphBase = "https://raw.githubusercontent.com/HCMID/chant/master/validation/neumes/"

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
    require(v.size == 4, "Neume:  wrong number of components in " + v + s" (v.size)")

    Neume(v(0), v(1), v(2), v(3))
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
        case 1 => Some(Porrectus)
        case 2 => Some(Torculus)
        case 3 => Some(Climacus)
        case 4 => Some(Scandicus)
        case 5 => Some(Tristropha)
        case 6 => Some(Trisvirga)
        case 7 => Some(Trigon)
        case i: Int => {
          println(s"Unrecognized ID ${i} for three-syllable neume.")
          None
        }
      }
      case 4  => neumeId match {
        case 1 => Some(PorrectusFlexus)
        case 2 => Some(PesSubBipunctis)
        case 3 => Some(ScandicusFlexus)
        case 4 => Some(TorculusResupinus)
        case i: Int => {
          println(s"Unrecognized ID ${i} for four-syllable neume.")
          None
        }
      }

      case 0 => neumeId match {
        case 1 => Some(SignificativeA)
        case 2 => Some(SignificativeB)
        case 3 => Some(SignificativeC)

        case 5 => Some(SignificativeE)
        case 6 => Some(SignificativeF)
        case 7 => Some(SignificativeI)
        case 8 => Some(SignificativeK)
        case 9 => Some(SignificativeL)
        case 10 => Some(SignificativeM)
        case 11 => Some(SignificativeP)
        case 12 => Some(SignificativeS)
        case 13 => Some(SignificativeT)
        case 14 => Some(SignificativeV)
        case 15 => Some(SignificativeX)
        case i: Int => {
          println(s"Unrecognized ID ${i} for significative letter.")
          None
        }
      }
    }
  }
}
