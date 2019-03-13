package com.github.gvolpe

import cats.Id
import cats.implicits._
import org.openjdk.jmh.annotations._

class benchmarks {
  import summoner._

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  def contextBoundSummoner(): Unit = p1[Id].replicateA(1000).void

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  def evidenceSummoner(): Unit = p2[Id].replicateA(1000).void

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  def contextBoundMacroSummoner(): Unit = p3[Id].replicateA(1000).void

}
