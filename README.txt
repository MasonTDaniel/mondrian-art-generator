# ModrianArtSource2018
Submitted by: Mason Daniel 12/3/2018

*Description:

This project was completed for a Programming Languages course at Southwestern University. The project was assigned by Dr. Barbara Anthony, and was inspired by a project from Ben Stephenson at the University of Calgary. The project was altered in that our solution was required to be submitted in Scala. Thus, this implementation utilizes Scala and its functional/object-oriented capabilities.

*Functions added:

splitRectangle()
This function takes in a rectangle and its x, y, width and height. It then plots two new rectangles that result in splitting the original. It also calls itself with the two new rectangles, and keeps plotting and splitting rectangles until it reaches a rectangle with a side less than 40.

pickPosition()
This function takes in a rectangle and its x, y, width and height, as well as a boolean parameter indicating whether the current rectangle will be split vertically or horizontally. If it will be split vertically, it finds a point along the top edge of the rectangle that will act as a reference point for the two new rectangles that result in splitting the original rectangle. It will mark the top-right corner of the rectangle on the left, and the top-left corner of the rectangle on the right. This function also has an offset so that the split will not occur too close the edge of the original rectangle. On the other hand, if the rectangle is to be split horizontally, this function does the same process but instead will find a point along the left side of the original rectangle. This will mark the bottom-left of the top rectangle, and the top-left of the bottom rectangle. The offset is also accounted for in this case.

getRandomColor()
This function simply returns a List when called. This list contains three ints, each from 0-255, that will represent a RGB color. 70% of the time, it will return white. For the other 30%, it will return a random shade of red, green, or blue. This is done by picking a random number between 0 and 9, where 0 = red, 1 = green, 2 = blue, and 3-9 = white.


*References*
I used the following URL for learning how to generate random numbers in Scala:
https://stackoverflow.com/questions/39402567/get-random-number-between-two-numbers-in-scala
