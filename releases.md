# `virgapes`: release notes

**6.1.0**: Add functions for formatting markdown and HTML links to glyphs for Neumes.


**6.0.0**:  API-breaking changes adding `VirgapesSyllable` and making classes cross compile properly for ScalaJS.


**5.0.0**:  API-breaking changes converting `Virgapes` to an object rather than a case class.


**4.0.0**:  API-breaking changes implementing version 2.0 of `MidOrthography` trait.


**3.7.0**:  Add new `VirgapesSyllables` class.

**3.6.0**:  Implement `MidOrthography` orthography trait.

**3.5.1**: fixes off-by-one bug in encoding of some significative letters.

**3.5.0**:  `toString` on `Neume`s now serializes to Virgapes format.

**3.4.0**:  Adds `AlignedWord` class.

**3.3.0**: `Aligner` object supports aligning directly from two parallel corpora, one of neumes in XML, and one of text in XML following HC MID conventions.


**3.2.0**: adds function to `Syllabifier` object to syllabify an OHCO2 corpus of XML text of neumes.


**3.1.0**: adds `StringPair` class with functions for coordinated display of text and neumes.

**3.0.1**: updates version dependencies for some included libraries.


**3.0.0**:  changes `liquescence` property on `Neume` from `Boolean` (presence of liquescence) to `Int` (pitch on which liquescence falls, 0 for no liquescence)

**2.0.0**:  rename `Syllabifier` factory object.

**1.1.0**: first attempt to cross publish in multiple Scala versions for JVM and JS.

**1.0.0**: initial binary release.
