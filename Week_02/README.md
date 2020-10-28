## 作业一 对串行、并行、CMS、G1GC 的理解

- 串行GC：单线程执行GC，GC效率不高，完成GC所需的时间长，暂停（STW）时间长；无GC时，无GC线程，不与业务线程抢CPU，业务线程能充分使用CPU，吞吐好。
- 并行GC：多线程执行GC，GC效率高，完成GC所需的时间短，暂停（STW）时间减少；无GC时，无GC线程，不与业务线程抢CPU，业务线程能充分使用CPU，吞吐好。
- CMSGC：多线程执行GC，将GC任务拆解成多个阶段，部分阶段的GC任务与业务线程并发执行，减少了GC时的任务量，进一步减少暂停（STW）时间；无GC时，有GC线程与业务线程抢CPU，会一定程度的降低业务线程的吞吐量。
- G1GC：多线程执行GC，将GC任务拆解成多个阶段，优化GC任务（增量标记、整理），部分阶段的GC任务与业务线程并发执行，减少了GC时的任务量，进一步减少暂停（STW）时间；无GC时，有GC线程与业务线程抢CPU，会一定程度的降低业务线程的吞吐量；由于使用拆分块的方式优化了GC任务，使得对要GC空间的大小不敏感，能应用在堆较大（大于4G）的情况下，能控制每次暂停（STW）的时间。
- 系统吞吐优先的情况下，考虑使用并行GC，在内存不大的情况下，GC暂停时间可控制在百毫秒内。
- 系统对延时十分敏感（20毫秒内），考虑使用G1GC 或 ZGC。
- 当前认为，常规的 web 后端服务，在配置的内存不大（小于4G）的情况下，使用并行GC或G1GC都可以。

## 作业二 使用 HttpClent 或 OkHtttp 连接 `http://localhost:8801`


```
# 在Mac环境中执行以下命令

# 使用 HttpClient 连接
cd HttpClientSample
javac -cp "lib/*" HttpClientSample.java
java -cp ".:lib/*" HttpClientSample

# 使用 OkHttp 连接
cd OkHttpSample
javac -cp "lib/*" OkHttpSample.java
java -cp ".:lib/*" OkHttpSample

```


