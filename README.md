# Computation-and-Complexity-Assignment
Assignment from CSCI 722 (Computation and Complexity)
Computer Theory (TC) Project Requirements and Submission Protocol for Phase#1
This document describes the project requirements for phase#1 of the TC Project. The code produced for this phase#1 for the most part will be necessary to complete phase#3 as well. (Phase #2 is called a “phase” of the TC Project for consistency, but in reality involves writing up and presenting information in MS Word. It is actually independent of the coding aspects of the TC Project.)
In the TC PROJECT PHASE#1 FILES directory under the Content tab folder on Blackboard system, there are files and tutorials for implementing command line parsing with flags and storing information using hashtables. (Java actually provides a number of hash based variants; I will let you decided which one you want to use.)
The project is to collect membership information for a person, store that information in a hashtable, read the information stored and output it to an OutputFile. Addmittedly, this project in and of itself does not have a significant application by itself; however, it is important to demonstrate the usage of command line arguments and hashing technology for the overall project and is understood as such. The main class and name of your program is Membership. You should have more than one class.
The notion of a command line flag is that input can be passed to a program via the arguments included at runtime (using the java command) instead of reading them from the keyboard or from a file. Your code should be able to parse commands given on the commandline (where “cmd:” is a possible command line prompt and not part of your command per se) such as
cmd: java Membership -firstname=Steve -lastname=Smith -phone=1234567890 -NewYork=false -outputFile=NameOfOutputFile -inputFile=InitialDataFile
where the Member name is Steve Smith, the Unique membership id is the phone number 1234567890 and Steve does not currently live in New York (hence, Boolean false). The first two parameters are strings, the phone is a number and NewYork is a Boolean; an output flag is the name of a file (if doesn’t exist, then you need to create it) where you will search the hashtable for all information pertaining to unique id 1234567890 and output it to the output file listed. The output file name will be held by a global class variable.
There is also to be an Initial Data File of five to ten made up records to test your program and this must be read in by your program prior to adding the current member. It should consist of rows containing the following information separated by | (note: the following are just column headers):
First name | Last name | Phone number id | Lives in New York?
This and all membership information should be wrapped into a single member object and entered into the hashtable membership database assuming the phone is a unique key for retrieval purposes. 
A couple of extra requirements:
1) these flags can appear in any order at commandline.
2) The phone number must be UNIQUE so you need to check whether it already exists in the hashtable membership database and output an error message with all membership information if the phone number id already exists.
3) You are to add an extra flag to indicate whether just the most recent member information is to be printed to the OutputFile or the entire membership of all members in hashtable should be outputted to output file. The output file will have the same format as the input file mentioned above. Hint: You will need to research how to iterate through all keys of a hashtable.
If Phase#1 is not submitted on time, one can still submit the other Phases.
Submission Protocol will now be described.
TC.P1.Task#1) Complete Java Code. Collect all the .java files necessary for your system into a single temporary directory on your computer system. 
TC.P1.Task#2) Commenting Statistics. Comment your code appropriately and use meaningful names for classes, methods, variables and constants. You are expected to report on the number of lines of code using cloc found at https://github.com/AlDanial/cloc/releases/tag/v1.98 This command must be run on the command line (cmd.exe). When you collect all .java files into the same temporary directory (see TC.P1.Task#1 above), then the following command will report on the contents of each .java file. The report generated by cloc program will report on the number of actual java code lines, blank lines, comment lines for each of the .java files that is part of your project. The command to obtain the report data is as follows (assuming you are using the above version):
cloc-1.98.exe --by-file *.java
This report should be copied into a text (.txt) file
TC.P1.Task#3) Key Uniqueness. For this task only, create a special initial data file that has Steve Smith’s information already there so that when you run the above mentioned java command with Steve Smith’s information, your system will recognize the duplication of the phone (id) key and reject the input from command line and as stated above (extra requirement#2), output this information with an error message to the OutputFile. 
TC.P1.Task#4) Command Line Flags (output). A main aspect of this phase is to demonstrate the ability to read input data from command line flags in any order. Using the Steve Smith data above, test your system three times, each time using the output switch option of printing out only the information pertaining to the current member added (here, Steve Smith). For the first time test the system with the information for Steve Smith provided above using the flags in the order that they appear above. For each of the next two times, at the command line choose two different orders of how the flags appear in the command line, both of which should be different than the other times. Use a different outputFile name for each of these three test runs. 
TC.P1.Task#5) Command Line Flags (code). Collect all the .java files necessary for previous task TC.P1.Task#4 into a single temporary directory on your computer system. 
TC.P1.Task#6) Wrapping data in an object. The hashtable data structure in Java at first glance seems to be limited, simply a pair of data values and if you match the key (the unique value), you then have access to the second stored valued. But, in our case, we have a number of pieces of information that need to be retrieved using the “key” (unique) value of the phone number as id. In our case, the values for {FirstName, LastName, Phone, NewYork} will all be placed into a data object and that object will be inserted into the hashtable under the key value Phone. (Although database people would probably frown upon having the Phone both as a key and also a data value, it will make your code a little easier by having all data values together.) 
TC.P1.Task#7) Output (Part 1). You were to provide an extra "output" switch which provided for two choices: printing the current membership information alone, or printing out the information for all members in the hashtable membership database. The user should be allowed to supply the name of the input and output files via command flags. Test your system using the option that prints out all members currently in the hashtable membership database. 
TC.P1.Task#8) Output (Part 2). Your extra "output" switch should provide for two choices: printing the current membership information alone, or printing out the information for all members in the hashtable membership database. The user should be allowed to supply the name of the input and output files via command flags.
TC.P1.Task#9) Persistence. Although not a coding requirement for this semester, clearly the project would be greatly enhanced if the data collected during runtime would remain in the hashtable membership database even after the program has executed. Then, this next time the program is started up, it could already have the data accumulated up to this point. This feature is called persistence. There are a number of ways to accomplish this. In fact, the hashtable api provides such a technology if handled correctly. In a text (.txt) file, write up how you can accomplish this (in paragraph form) and if you find snippets of code on the web that accomplish this, include them in your report with the correct url indicating where you located them. 
TC.P1.Task#10) Overall Project Assessment. Read over the specifications for this phase. Type into a text (.txt) file a report on what was accomplished and what was not accomplished in your submission (TC.P1.Task#1 above). What functionality that you submitted works and which functionality in your code does not work. For the latter, what do you think is causing the problem? This report should be typed into a text (.txt) file.

