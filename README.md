summoner-benchmarks
===================

Source code for the benchmarks [published in my blog](https://gvolpe.github.io/blog/context-bound-vs-implicit-evidence/).

### Without `-opt:l:inline` flag

```
sbt> jmh:run -i 20 -wi 5 -f1 -t1
[info] Benchmark                   Mode  Cnt      Score      Error  Units
[info] contextBoundMacroSummoner  thrpt   20  16005.191 ± 1159.824  ops/s
[info] contextBoundSummoner       thrpt   20  16983.623 ±  345.910  ops/s
[info] evidenceSummoner           thrpt   20  15150.217 ±  863.405  ops/s
```

### With `-opt:l:inline` flag

Notice that the JVM bytecode does not change but somehow the results were favorable.

```
sbt> jmh:run -i 20 -wi 5 -f1 -t1
[info] Benchmark                   Mode  Cnt      Score     Error  Units
[info] contextBoundMacroSummoner  thrpt   20  16461.507 ± 572.363  ops/s
[info] contextBoundSummoner       thrpt   20  16341.987 ± 672.911  ops/s
[info] evidenceSummoner           thrpt   20  17074.474 ± 482.748  ops/s
```
