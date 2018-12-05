# ModrianArtSource2018
Submitted by: Mason Daniel 12/3/2018

Files Submitted: 
README..txt
ModrianStarter.scala
Assignment11BookProblems.doc

*Functions added:

splitRectangle()
This function takes in a rectangle and its x, y, width and height. It then plots two new rectangles that result in splitting the original. It also calls itself with the two new rectangles, and keeps plotting and splitting rectangles until it reaches a rectangle with a side less than 40.

pickPosition()
This function takes in a rectangle and its x, y, width and height, as well as a boolean parameter indicating whether the current rectangle will be split vertically or horizontally. If it will be split vertically, it finds a point along the top edge of the rectangle that will act as a reference point for the two new rectangles that result in splitting the original rectangle. It will mark the top-right corner of the rectangle on the left, and the top-left corner of the rectangle on the right. This function also has an offset so that the split will not occur too close the edge of the original rectangle. On the other hand, if the rectangle is to be split horizontally, this function does the same process but instead will find a point along the left side of the original rectangle. This will mark the bottom-left of the top rectangle, and the top-left of the bottom rectangle. The offset is also accounted for in this case.

getRandomColor()
This function simply returns a List when called. This list contains three ints, each from 0-255, that will represent a RGB color. 70% of the time, it will return white. For the other 30%, it will return a random shade of red, green, or blue. This is done by picking a random number between 0 and 9, where 0 = red, 1 = green, 2 = blue, and 3-9 = white.


*Summary

This project was not super difficult, and the only time I used the Internet was to find documentation on how to generate a random number in Scala. A lot of it was up to us and our problem solving to figure out, which made it very fun. Additionally, the results are interesting and actually tangible, so it was a rewarding project. The only real hold-up I came across was after implementing my functions, I was getting an Illegal Argument Exception. This was due to declaring a new random point to split the rectangle outside of the possible boundaries. Once I found the root to the problem, I actually got a decent result. After some minor fixes, I came out with something that I think works. The only real limitation to it is on the right side, it seems that there is always a white rectangle. I am not sure if this has to do with when I split the rectangle intitally, or if it has to do with how I declare the boundaries of my first rectangle, but I could not seem to fix that problem. Besides that, it seems to perform the main function required, which is recursively splitting rectangles and giving them random shades of red, green, and blue. 

This project was a great way to get some more Scala experience, especially since it was so do-able but still challenging. It was also a very suitable language for this type of problem given its functional and object-oriented nature.



References
I used the following URL for learning how to generate random numbers in Scala:
https://stackoverflow.com/questions/39402567/get-random-number-between-two-numbers-in-scala

I also spoke with Elyssa, Colin, Jacob, and Isabel about the overall idea on approaching this project.

I have acted with honesty and integrity in producing this work and am unaware of anyone who has not.
Mason Daniel