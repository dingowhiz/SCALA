import org.apache.spark.sql.SparkSession

object SparkExample extends App {
  
  // Create Spark session
  val spark = SparkSession.builder()
    .appName("Spark Example")
    .master("local[*]") // Run locally with all available cores
    .config("spark.sql.adaptive.enabled", "true")
    .config("spark.sql.adaptive.coalescePartitions.enabled", "true")
    .getOrCreate()
  
  // Import implicits for DataFrames
  import spark.implicits._
  
  println("🚀 Spark Session Created Successfully!")
  println(s"Spark Version: ${spark.version}")
  println(s"Scala Version: ${scala.util.Properties.versionString}")
  
  // Create a simple DataFrame
  val data = Seq(
    ("Alice", 25, "Engineer"),
    ("Bob", 30, "Data Scientist"),
    ("Charlie", 35, "Manager"),
    ("Diana", 28, "Developer")
  )
  
  val df = data.toDF("Name", "Age", "Job")
  
  println("\n📊 Sample DataFrame:")
  df.show()
  
  println("\n📈 DataFrame Statistics:")
  df.describe("Age").show()
  
  // Filter and group operations
  println("\n🔍 People over 27:")
  df.filter($"Age" > 27).show()
  
  println("\n👥 Count by Job:")
  df.groupBy("Job").count().show()
  
  // Stop Spark session
  spark.stop()
  println("\n✅ Spark session stopped. Example completed!")
}
