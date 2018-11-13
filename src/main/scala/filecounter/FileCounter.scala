package filecounter

import java.io.File
import scala.io.Source
import filecounter.util.LineParsers._

class FileCounter {

  def countFiles(implicit path: String): Int = traverse(_ => 1)

  def countLines(implicit path: String): Int = traverse(_.size)

  def countWhitespace(implicit path: String): Int = traverse(parse(_, isWhitespace))

  def countComments(implicit path: String): Int = traverse(parse(_, isComment))

  def countCode(implicit path: String): Int = traverse(parse(_, isCode))

  private def traverse(f: List[String] => Int)(implicit path: String): Int = {
    def count(dir: File): Int = {
      dir.listFiles.toList.foldLeft(0) { (counter, file) =>
        counter + (if (file.isFile) f(Source.fromFile(file).getLines.toList) else count(file))
      }
    }

    getValidDirectory.map(count).getOrElse(0)
  }

  private def getValidDirectory(implicit path: String): Option[File] = {
    if (path == null) {
      None
    } else {
      val directory = new File(path)
      if (directory.exists && directory.isDirectory) {
        Some(directory)
      } else {
        None
      }
    }
  }
}
