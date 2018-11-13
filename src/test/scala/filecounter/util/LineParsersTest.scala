package filecounter.util

import filecounter.util.LineParsers._
import org.scalatest.WordSpec

class LineParsersTest extends WordSpec {
  
  "LineParsers" when {
    "isWhitespace" should {
      "return true if empty string" in {
        assert(isWhitespace(""))
      }

      "return true if blank string" in {
        assert(isWhitespace("     "))
      }

      "return false if any character in string" in {
        assert(!isWhitespace("false"))
      }
    }

    "isComment" should {
      "return true if line starts with //" in {
        assert(isComment("// test"))
      }

      "return true if line starts with #" in {
        assert(isComment("# test"))
      }

      "return true if line starts with whitespace before //" in {
        assert(isComment("     //"))
      }

      "return false if line does not start with // or #" in {
        assert(!isComment("false"))
      }
    }

    "isCode" should {
      "return false if line starts with //" in {
        assert(!isCode("// test"))
      }

      "return false if line starts with #" in {
        assert(!isCode("# test"))
      }

      "return false if line starts with whitespace before //" in {
        assert(!isCode("     //"))
      }

      "return false if empty string" in {
        assert(!isCode(""))
      }

      "return false if blank string" in {
        assert(!isCode("     "))
      }

      "return true if any other character is in the line" in {
        assert(isCode("true"))
      }
    }
  }
}
