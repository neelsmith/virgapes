package edu.holycross.shot.virgapes
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._

import scala.scalajs.js
import scala.scalajs.js.annotation._

/** A class representing an ordered sequence of [[Neume]]s
* on a single syllable of text.
*
* @param neumes Vector of [[Neume]]s on a single syllable of text.
*/
@JSExportAll case class Syllable(neumes: Vector[Neume]) {
  require (neumes.size > 0, "Cannot create syllable from empty vector.")
  /** Number of neumes on this syllable.
  */
  def size: Int = {
    neumes.size
  }
}
