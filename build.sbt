name := "non-empty-string"

version := "0.1.0"

scalaVersion := "3.5.2"

crossScalaVersions := Seq("2.12.20", "2.13.15", "3.5.2")

libraryDependencies += "org.scalameta" %% "munit" % "1.0.2" % Test

scalacOptions ++= Seq(
  "-Ywarn-unused"
)
