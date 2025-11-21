name := "spark-hdfs-sample"

version := "0.1.0"

scalaVersion := "2.12.17"

lazy val sparkVersion = "3.4.0"
lazy val hadoopVersion = "3.3.6"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql"  % sparkVersion,
  "org.apache.hadoop" % "hadoop-client" % hadoopVersion % "provided",
  // make logback provided so Log4J (你的 log4j.properties) 控制运行时日志，避免实现冲突
  "ch.qos.logback" % "logback-classic" % "1.2.11" % "provided",
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-streaming-kafka-0-10" % sparkVersion
)

// 确保 run 时 fork 出来的 JVM 使用 UTF-8 并指定 log4j 配置
ThisBuild / fork := true

ThisBuild / javaOptions ++= Seq(
  "-Dfile.encoding=UTF-8",
  "-Duser.language=zh",
  "-Duser.country=CN",
  "-Dlog4j.configuration=file:src/main/resources/log4j.properties"
)

// sbt-assembly settings (for creating a fat jar if needed)
ThisBuild / assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case "reference.conf"              => MergeStrategy.concat
  case x                             => MergeStrategy.first
}

// Specify the main class for the assembly jar
ThisBuild / assembly / mainClass := Some("mapsideJoin")

