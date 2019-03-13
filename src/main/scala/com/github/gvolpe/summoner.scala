package com.github.gvolpe

import cats._
import cats.effect._
import cats.implicits._

object summoner extends IOApp {

  def p1[F[_]: Applicative: Console]: F[Unit] =
    Console[F].putStrLn("a") *>
      Console[F].putStrLn("b") *>
      Console[F].putStrLn("c")

  def p2[F[_]](implicit ev: Applicative[F], c: Console[F]): F[Unit] =
    c.putStrLn("a") *>
      c.putStrLn("b") *>
      c.putStrLn("c")

  def p3[F[_]: Applicative: Console]: F[Unit] =
    ConsoleOpt[F].putStrLn("a") *>
      ConsoleOpt[F].putStrLn("b") *>
      ConsoleOpt[F].putStrLn("c")

  def run(args: List[String]): IO[ExitCode] =
    (p1[IO] *> p2[IO] *> p3[IO]).as(ExitCode.Success)

}

trait Console[F[_]] {
  def putStrLn[A](a: A): F[Unit]
}

object Console {
  @inline final def apply[F[_]](implicit ev: Console[F]): Console[F] = ev

  implicit def syncConsole[F[_]: Sync]: Console[F] =
    new Console[F] {
      def putStrLn[A](a: A): F[Unit] = Sync[F].delay(println(a))
    }

  implicit val idConsole: Console[Id] =
    new Console[Id] {
      def putStrLn[A](a: A): Id[Unit] = ()
    }
}

object ConsoleOpt {
  import imp.summon
  import language.experimental.macros

  def apply[F[_]: Console]: Console[F] = macro summon[Console[F]]
}
