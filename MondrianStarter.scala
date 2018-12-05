import java.io._



object Mondrian {
    // This value is the size of the image to produce 
    val canvasSize = 500
    // This is an offset so that the image doesn't appear in the far
    // upper left corner of the window
    val canvasOffset = 50
    // The idea of the above parameters is that the square between (50,50)
    // and (550,550) will contain the Mondrian image
    
  	def main(args: Array[String]) {
  	  println("Running Mondrian art generator")
  	  
  	  // Assemble the html page containing the svg image in three components:
  	  //    the header, the body consisting of a list of <rect> elements and the footer
  	  val htmlText = getHeader(canvasSize + 2*canvasOffset) + 
  	                 getAllRectangles() + 
  	                 getFooter()
  	                   	                 
  	  // Write the results to the html file
  	  writeFile("mondrian.html", htmlText);
  	  println("Wrote results to mondrian.html")
  	}
  	
    // Generate the html and svg header elements
  	def getHeader(svgSize:Int):String = {
  	  return "<!DOCTYPE html>\n<html>\n<body>\n<svg width=\""+svgSize+"\" height=\""+svgSize+"\">\n"
  	}
  	
  	/*
  	 * Produce string containing for sequence of svg <rect> elements defining
  	 * a Mondrian-style colored grid. Implementing this function should involve
  	 * calling one or more helper functions, some of which are recursive.
  	 */
  	def getAllRectangles():String = {
  	  // This value stores the length of the largest rectangle's sides, aka the original rectangle 
  	  val firstSquareSideLength = canvasSize - canvasOffset
  	  // Call getRectangle to plot the first rectangle, then call splitRectangle to split it
  	  return getRectangle(canvasOffset, canvasOffset, firstSquareSideLength, firstSquareSideLength, getRandomColor()) + splitRectangle(canvasOffset, canvasOffset, firstSquareSideLength, firstSquareSideLength)
  	}
  	
  	/*
  	 * Split a rectangle into two adjacent rectangles
  	 * This is a recursive function and will keep splitting rectangles until the rectangle has a side smaller than 40
  	 * If the the rectangle wider than it is tall or is a square, it will be split vertically. Otherwise, it will be split horizontally
  	 */
  	def splitRectangle(x:Int, y:Int, width:Int, height:Int):String = {
  	  // Base case: if either side of the rectangle is less than 40, do not split the rectangle
  	  if (width < 40 || height < 40) {
  	    return ""
  	  }
  	  // Boolean to determine which way the rectangle will be split
  	  var verticalSplit = true
  	  // If the rectangle is taller than it is wide, set verticalSplit to false meaning we will horizontally split
  	  if (width < height) {
  	    verticalSplit = false
  	  }
  	  // If we are going to split vertically
  	  if (verticalSplit) {
  	    // This will hold a new point along the top edge that is shared by two adjacent rectangles that were just split vertically
  	    var newCornerX = pickPosition(x, y, width, height, verticalSplit)
  	    // Plot both new rectangles and then split both rectangles
  	    return getRectangle(x, y, newCornerX-x, height, getRandomColor()) + getRectangle(newCornerX, y, width-newCornerX, height, getRandomColor()) + splitRectangle(x, y, newCornerX-x, height) + splitRectangle(newCornerX, y, width-newCornerX, height)
  	  }
  	  // If we are going to split horizontally
  	  else {
  	    // This will hold a new point along the left edge that is shared by two adjacent rectangles that were just split horizontally
  	    var newCornerY = pickPosition(x, y, width, height, verticalSplit)
  	    // Plot both new rectangles and then split both rectangles
  	    return getRectangle(x, y, width, newCornerY-y, getRandomColor()) + getRectangle(x, newCornerY, width, height-newCornerY, getRandomColor()) + splitRectangle(x, y, width, newCornerY-y) + splitRectangle(x, newCornerY, width, height-newCornerY)
  	  }
  	}
  	
  	/*
  	 * Pick a random position to split the rectangles
  	 * If we are going to split vertically, choose a point along the top edge of the rectangle-to-be-split that will mark
  	 * 	the top-right corner of the left rectangle and top-left corner of the right rectangle after splitting
  	 * If we are going to split horizontally, choose a point along the left edge of the rectangle-to-be-split that will mark
  	 * 	the bottom-left corner of the top rectangle and the top-left corner of the right rectangle after splitting
  	 */
  	def pickPosition(x:Int, y:Int, width:Int, height:Int, verticalSplit:Boolean):Int = {
  	  // This value will be used to make sure that the rectangle is not split too close to its current edges
  	  val boundaryOffset = 20
  	  // If we are going to split vertically
  	  if (verticalSplit) {
  	    // Declare new random object
  	    val random = new scala.util.Random
  	    // Set the left boundary just next to the left side of the rectangle
  	    val start = x + boundaryOffset
  	    // Set the right boundary just next to the right side of the rectangle
  	    val end = (x + width) - boundaryOffset
  	    // Find a point somewhere in between the two boundaries and return it
  	    val newNum = start + random.nextInt( (end - start) + 1 )
  	    return newNum
  	  } 
  	  // If we are going to split horizontally
  	  else {
  	    // Declare new random object
  	    val random = new scala.util.Random
  	    // Set the top boundary just below the top side of the rectangle
  	    val start = y + boundaryOffset
  	    // Set the bottom boundary just above the bottom side of the rectangle
  	    val end = (y + height) - boundaryOffset
  	    // Find a point somewhere in between the two boundaries and return it
  	    val newNum = start + random.nextInt( (end - start) + 1 )
  	    return newNum
  	  }
  	}
  	
  	/*
  	 * Return a list with three values ranging from 0-255 resulting in the color white or
  	 *  a random shade of red, green, or blue
  	 *  Will return white 70% of the time
  	 *  Will return a shade of red, green, or blue 30% of the time
  	 */
  	def getRandomColor(): List[Int] = {
  	  // Declare new random object
  	  val random = new scala.util.Random
  	  // Store random number from 0-9
  	  val randomNum = random.nextInt(10)
  	  // Store max possible value when determining RGB colors
  	  val maxColorNum = 255;
  	  // If random number is 0
  	  if (randomNum == 0) {
  	    // Return random shade of red
  	    val color = random.nextInt(maxColorNum)
  	    return List(maxColorNum,color,color)
  	  }
  	  // If random number is 1
  	  else if (randomNum == 1) {
  	    // Return random shade of green
  	    val color = random.nextInt(maxColorNum)
  	    return List(color,maxColorNum,color)
  	  } 
  	  // If random number is 2
  	  else if (randomNum == 2) {
  	    // Return random shade of blue
  	    val color = random.nextInt(maxColorNum)
  	    return List(color,color,maxColorNum) 
  	  } 
  	  // Otherwise, random number was greater than 2
  	  else {
  	    // Return white
  	    return List(maxColorNum,maxColorNum,maxColorNum)
  	  }
  	}

  	/// Generate the closing tags for the main html and svg elements
  	def getFooter():String = {
  	  return "</svg>\n</body>\n</html>"
  	}
  	
    // Write a string to a file prescribed
  	def writeFile(filename:String, text:String) = {
  	  val file = new File(filename)
      val bw = new BufferedWriter(new FileWriter(file))
      bw.write(text)
      bw.close()
  	}
  	
   	/*
  	 * Create the SGV <rect> element defining a rectangle at a specified position (x,y)
  	 * and with specified width, height and color. The color is passed as a list of integers
  	 * in the argument rgb: this list should have length 3 and contain the red, green and 
  	 * blue values for the color. Each component should be between 0 ad 255 inclusive.
  	 */
  	def getRectangle(x:Int, y:Int, 
  	                 width:Int, height:Int, 
  	                 rgb:List[Int]):String = {  	  
  	  return "<rect x=\"" + x + "\" y=\"" + y + "\" " +
  	          "width=\"" + width + "\" height=\"" + height + "\" " +
              "style=\"fill:rgb("+rgb.mkString(",")+");stroke-width:3;stroke:rgb(0,0,0)\" />"
  	} 	
}
