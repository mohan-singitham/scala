
object Main {

  case class Branch(Node: Long, leftNode: Option[Branch], rightNode: Option[Branch])

  def main(args: Array[String]) = {
    val inp = Branch(10, Some(Branch(6, Some(Branch(5, None, None)), None)), Some(Branch(12, Some(Branch(11, None, None)), None))) //pass scenario
    //val inp = Branch(10, Some(Branch(6, Some(Branch(5, None, None)), None)), Some(Branch(12, Some(Branch(13, None, None)), None))) //fail scenario
    if (checkBSTMinMax(Some(inp), Int.MinValue, Int.MaxValue)) println("valid BST") else println("Not a Valid BST")
  }

  def checkBSTMinMax(inp: Option[Branch], minVal: Long, maxVal: Long): Boolean = {
    if (inp.isEmpty) return true
    else if (inp.get.leftNode.isDefined && (inp.get.leftNode.get.Node < minVal)) return false
    else if (inp.get.rightNode.isDefined && (inp.get.rightNode.get.Node > maxVal)) return false
    checkBSTMinMax(inp.get.leftNode, minVal, inp.get.Node - 1) && checkBSTMinMax(inp.get.rightNode, inp.get.Node + 1, maxVal)
  }
}