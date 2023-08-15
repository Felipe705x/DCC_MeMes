object Main {
  trait geometry{
    def getPos(): (Int, Int)
    def translate(dx: Int,dy: Int): Unit
  }
  class Point(private var x: Int, private var y: Int) extends geometry{
    def getPos(): (Int, Int) = {
      (x,y)
    }
    def translate(dx: Int, dy: Int): Unit = {
      x = x + dx
      y = y + dy
    }
    override def toString(): String = "*"
  }
  class Rectangle(private var origin: Point, private val width: Int, private val height: Int) extends geometry{
    def getPos(): (Int, Int) = {
      origin.getPos()
    }
    def translate(dx: Int, dy: Int): Unit = {
      origin.translate(dx,dy)
    }
    def getArea(): Int ={
      width*height
    }
    override def toString(): String = {
      var t_line: String = "*  "
      for(columns <- 1 to width){
        t_line = t_line + "-  "
      }
      t_line = t_line + "\n"
      var m_line: String = "|  "
      for(columns <- 1 to width-1){
        m_line = m_line + "   "
      }
      m_line = m_line + "|" + "\n"
      var b_line: String = ""
      for (columns <- 0 to width) {
        b_line = b_line + "-  "
      }
      var result: String = t_line
      for(lines <- 0 to height -2){
        result = result + m_line
      }
      result = result + b_line
      result
    }
  }

  def main(args: Array[String]): Unit = {
    val point: Point = new Point(0,0)
    val rectangle1: Rectangle = new Rectangle(point, 10, 3)
    val rectangle2: Rectangle = new Rectangle(point, 10, 5)
    rectangle2.translate(3, 5)
    println("La posición del punto es (x,y) = "+ rectangle2.getPos())
    println("El area de rectangle1 es A = " + rectangle1.getArea())
    println("Representación de un punto: " + point.toString())
    println("Representación de rectangle2: \n")
    println(rectangle2.toString())
  }
}