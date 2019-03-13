import sbt._

object Dependencies {

  object Versions {
    val cats       = "1.6.0"
    val catsEffect = "1.2.0"
    val imp        = "0.3.0"

    val betterMonadicFor = "0.3.0-M4"
    val kindProjector    = "0.9.8"
    val macroParadise    = "2.1.0"
  }

  object Libraries {
    lazy val cats       = "org.typelevel"         %% "cats-core"      % Versions.cats
    lazy val catsEffect = "org.typelevel"         %% "cats-effect"    % Versions.catsEffect
    lazy val imp        = "org.spire-math"        %% "imp"            % Versions.imp

    def reflect(version: String) = "org.scala-lang"        %  "scala-reflect"  % version

    // Compiler plugins
    lazy val betterMonadicFor    = "com.olegpy"            %% "better-monadic-for"         % Versions.betterMonadicFor
    lazy val kindProjector       = "org.spire-math"        %% "kind-projector"             % Versions.kindProjector
    lazy val macroParadise       = "org.scalamacros"       %  "paradise"                   % Versions.macroParadise cross CrossVersion.full
  }

}
