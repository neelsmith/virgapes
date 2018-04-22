---
layout: page
title:  Neumes
---


Import the library:




The basic object in the library is a `Neume`.  You can create it from a `String` in virgapes notation, and then work with the neume's components.

Example:  the string `1.2.0.0` represents a one-syllable neume with ID 2, no episema (ie, episema on syllable 0), and no liquescence.


```tut:silent
import edu.holycross.shot.virgapes._

val neume = Neume("1.2.0.0")
assert(neume.name == "punctum")
assert(neume.pitches == 1)
assert(neume.episema == 0)
assert(neume.liquescence == false)
```

You can also retrieve a `NeumeType`  option for a `Neume`.

```tut:silent
val nType = neume.neumeType
assert(nType.get == Punctum)
```

See the [API docs](https://neelsmith.github.io/virgapes/api/edu/holycross/shot/virgapes/index.html) for  more information.
