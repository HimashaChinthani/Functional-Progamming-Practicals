import scala.io.StdIn._

object StudentRecords {

 
  def getStudentInfo(name: String, marks: Int, totalMarks: Int): (String, Int, Int, Double, Char) = {
    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }
    (name, marks, totalMarks, percentage, grade)
  }

 
  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Student Name: $name")
    println(s"Marks Obtained: $marks / $totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }

 
  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.trim.isEmpty) {
      (false, Some("Name cannot be empty"))
    } else if (marks < 0 || marks > totalMarks) {
      (false, Some("Marks should be between 0 and the total possible marks"))
    } else {
      (true, None)
    }
  }


  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var valid = false
    var name = ""
    var marks = 0
    var totalMarks = 0

    while (!valid) {
      println("Enter student's name:")
      name = readLine()
      println("Enter marks obtained:")
      marks = readInt()
      println("Enter total possible marks:")
      totalMarks = readInt()

      val (isValid, errorMessage) = validateInput(name, marks, totalMarks)
      if (isValid) {
        valid = true
      } else {
        println(s"Invalid input: ${errorMessage.getOrElse("Unknown error")}. Please try again.")
      }
    }

    getStudentInfo(name, marks, totalMarks)
  }

  def main(args: Array[String]): Unit = {
    val studentRecord = getStudentInfoWithRetry()
    printStudentRecord(studentRecord)
  }
}
