# histogram-coding-challenge
This is my submittal for HEB's Developer I coding challenge. 

## Getting Started
Running the HistogramRunner.java file in /src directory will read input.txt. When run, ParagraphHistogram will create (or overwrite file if already exists) output.txt in root directory with a histogram of the words from input.txt.

## Example

### Input.txt 
```
Hickory, dickory, dock.
The mouse ran up the clock.
The clock struck one,
The mouse ran down,
Hickory, dickory, dock.
``` 

### Output.txt
```
     the | ==== (4)
 hickory | == (2)
 dickory | == (2)
    dock | == (2)
   mouse | == (2)
     ran | == (2)
   clock | == (2)
      up | = (1)
  struck | = (1)
     one | = (1)
    down | = (1)
```


