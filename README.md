# go-vs-java
A quick file io test with Java and Go.

## Instructions

Install Go and Java on your machine.

Build the Go native machine code executable:
```
go build io_benchmark.go
```

Build the Java JVM application:
```
javac IOBenchmark.java
```

Execute the Go application:
```
./io_benchmark
```

Execute the Java application:
```
java IOBenchmark
```

Your output should look something like this:
```
Go IO Performance Test
Write duration: 18.706291ms
Read duration: 3.998792ms

Java IO Performance Test
Write duration: 86 ms
Read duration: 39 ms
```