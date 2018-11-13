package filecounter.util

object LineParsers {
  implicit def booleanToInt(b: Boolean): Int = if (b) 1 else 0

  def parse(lines: List[String], f: String => Int): Int = lines.map(f).sum

  def isWhitespace(line: String): Boolean = line.trim.isEmpty

  def isComment(line: String): Boolean = line.trim.startsWith("//") || line.trim.startsWith("#")

  def isCode(line: String): Boolean = !isWhitespace(line) && !isComment(line)
}
