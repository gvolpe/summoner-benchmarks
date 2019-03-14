import Dependencies._

ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.github.gvolpe"
ThisBuild / organizationName := "summoner-benchmarks"

enablePlugins(JmhPlugin)

lazy val commonScalacOptions = Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:experimental.macros",
  "-Ypartial-unification",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-value-discard",
  "-Xfuture",
  "-Xlog-reflective-calls",
  "-Ywarn-inaccessible",
  "-Ypatmat-exhaust-depth",
  "20",
  "-Ydelambdafy:method",
  "-Xmax-classfile-name",
  "100",
  "-opt:l:inline",
  "-opt-inline-from:**"
)

lazy val root = (project in file("."))
  .settings(
    name := "summoner-benchmarks",
    scalafmtOnCompile := true,
    scalacOptions ++= commonScalacOptions,
    libraryDependencies ++= Seq(
      Libraries.imp % "provided",
      Libraries.reflect(scalaVersion.value) % "provided",
      Libraries.cats,
      Libraries.catsEffect
    )
  )
