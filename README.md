FreeCell-cli
============
### Description
Simple game of Freecell played from the command line or using txt file as input.

### Playing by command line:
Enter the source and destination column numbers seperated by a space to make a move. 
For example, to move top card from cascade row 10 to freecell row 1, would enter "`10 1`" and push enter. 
The new board is shown and you can chose next move.
Enter `0` to quit.

### Playing by file: 
Create a `TXT` file with 1 move pair per line.
When launching from command line, include filename as argument: " `java FreeCellPlay <filename> `"
