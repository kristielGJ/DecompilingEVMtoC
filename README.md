# DecompilingEVMtoC

This  project  is  an  academic  proposal  supervised  by  Martin  Nyx  Brain  and  Michał  Król.  The
project  will  be  to  write  a  decompiler  so  that  it  can  convert  EVM  byte  code  into  C  that  can  be
handled by the CPROVER tools


### [How to Compile and run the Decompiler Java program:]()

Requirements:

You must have Java , and the JVM downloaded on your device,
see [https://www.java.com/en/](https://www.java.com/en/)

Visual Code:

Simply open the src folder in Visual Studio Code, go to the
decompile package and run the main function in the java fine : EvmDecompile.java


Run in terminal:

1. Run a command to find all files with the extension
   .java once you have navigated to the correct src folder:

find .  -name"*.java"

2. Save these names in a text file:

find .  -name"*.java" >source.txt

3. Compile every java file using javac :

javac @source.txt

4. Once the files have been compiled, run the EvmDecompile
   class, where the main function Is located:

java -cp . src.decompiler.EvmDecompile

Example:

![](file:////Users/gerajahja/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image002.png)
