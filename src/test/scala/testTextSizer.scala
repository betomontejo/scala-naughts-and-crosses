// src/test/scala/testTextSizer.scala

import org.scalatest._

class TestTextSizer extends FunSpec with ShouldMatchers {

  val x = "x"
  val o = "o"
  val n = ""
  def lineWinner(line : List[String]) = {
    def lineWinnerItr(currentWinner: String, line : List[String]) : String = {
      line match {
        case Nil => currentWinner
        case head::tail => 
          if (head == n) n 
          else if (head == currentWinner) lineWinnerItr(head, tail) 
          else n
      }
    }
    lineWinnerItr(line.head, line.tail)
  }
def gameWinner(board: List[String])={

}
  describe("A naughts and crosses game") {
    
    describe("A row, column or diagonal") {

      it("should declare a winner when 3 matching symbols in a line") {
        lineWinner(x::x::x::Nil) should be (x)
      }

      it("should declare the correct winning player") {
        lineWinner(o::o::o::Nil) should be (o)
      }

      it("should not declare a winner when 3 symbols do not match") {
        lineWinner(x::o::x::Nil) should be (n) 
      }
    }

    it("should declare a winner when any row, column or diagaonal is won") {
      var state = List(x, x, x, o, n, o, n, o, n)
      gameWinner(state) should be (x)
    }
  }
}
