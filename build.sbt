organization := "com.aurelpaulovic"

name := "transactions-api"

version := "0.1"

scalaVersion := "2.11.2"

scalacOptions ++= Seq(
    "-encoding", "UTF-8",
    "-feature",
    "-deprecation",
    "-language:implicitConversions",
    "-language:existentials",
    "-language:higherKinds",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-explaintypes"
)

EclipseKeys.eclipseOutput := Some("target/eclipse")
