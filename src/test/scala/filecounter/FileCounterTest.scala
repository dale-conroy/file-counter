package filecounter

import org.scalatest.WordSpec

class FileCounterTest extends WordSpec {
  final val testDir = "/Users/dco54/workspace/file-counter/src/test"

  val fileCounter = new FileCounter

  "FileCounter" when {
    "countFiles" should {
      "return 0 files in null directory" in {
        val count: Int = fileCounter.countFiles(null)
        assert(count == 0)
      }

      "return 0 files in unknown directory" in {
        val count: Int = fileCounter.countFiles(s"$testDir/unknown")
        assert(count == 0)
      }

      "count all files in resources" in {
        val count: Int = fileCounter.countFiles(s"$testDir/resources")
        assert(count == 6)
      }
    }

    "countLines" should {
      "return 0 lines in null directory" in {
        val count: Int = fileCounter.countLines(null)
        assert(count == 0)
      }

      "return 0 lines in unknown directory" in {
        val count: Int = fileCounter.countLines(s"$testDir/unknown")
        assert(count == 0)
      }

      "count all lines in resources" in {
        val count: Int = fileCounter.countLines(s"$testDir/resources")
        assert(count == 60)
      }
    }

    "countWhitespace" should {
      "return 0 whitespace in null directory" in {
        val count: Int = fileCounter.countWhitespace(null)
        assert(count == 0)
      }

      "return 0 whitespace in unknown directory" in {
        val count: Int = fileCounter.countWhitespace(s"$testDir/unknown")
        assert(count == 0)
      }

      "count all whitespace in resources" in {
        val count: Int = fileCounter.countWhitespace(s"$testDir/resources")
        assert(count == 20)
      }
    }

    "countComments" should {
      "return 0 comments in null directory" in {
        val count: Int = fileCounter.countComments(null)
        assert(count == 0)
      }

      "return 0 comments in unknown directory" in {
        val count: Int = fileCounter.countComments(s"$testDir/unknown")
        assert(count == 0)
      }

      "count all comments in resources" in {
        val count: Int = fileCounter.countComments(s"$testDir/resources")
        assert(count == 10)
      }
    }

    "countCode" should {
      "return 0 code in null directory" in {
        val count: Int = fileCounter.countCode(null)
        assert(count == 0)
      }

      "return 0 code in unknown directory" in {
        val count: Int = fileCounter.countCode(s"$testDir/unknown")
        assert(count == 0)
      }

      "count all code in resources" in {
        val count: Int = fileCounter.countCode(s"$testDir/resources")
        assert(count == 30)
      }
    }
  }
}
