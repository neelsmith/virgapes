name := "Virgapes utilities"

crossScalaVersions in ThisBuild := Seq("2.11.8", "2.12.4")
scalaVersion := (crossScalaVersions in ThisBuild).value.last


lazy val root = project.in(file(".")).
    aggregate(crossedJVM, crossedJS).
    settings(
      publish := {},
      publishLocal := {}

    )

lazy val crossed = crossProject.in(file(".")).
    settings(
      name := "virgapes",
      organization := "edu.holycross.shot",
      version := "6.1.0",
      licenses += ("GPL-3.0",url("https://opensource.org/licenses/gpl-3.0.html")),
      resolvers += Resolver.jcenterRepo,
      resolvers += Resolver.bintrayRepo("neelsmith", "maven"),
      libraryDependencies ++= Seq(
        "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % "provided",
        "org.scalatest" %%% "scalatest" % "3.0.1" % "test",


        "edu.holycross.shot.cite" %%% "xcite" % "3.7.0",
        "edu.holycross.shot" %%% "ohco2" % "10.11.2",

        "edu.holycross.shot" %%% "latphone" % "2.3.1",

        "edu.holycross.shot" %%% "midvalidator" % "5.6.0"

      )
    ).
    jvmSettings(
      libraryDependencies ++= Seq(
      //  "edu.holycross.shot.mid" %%% "latin-text-model" % "1.3.0"
      ),
      tutTargetDirectory := file("docs"),
      tutSourceDirectory := file("tut")
    ).
    jsSettings(
      skip in packageJSDependencies := false,
      scalaJSUseMainModuleInitializer in Compile := true
    )


lazy val crossedJVM = crossed.jvm.enablePlugins(TutPlugin)
lazy val crossedJS = crossed.js
