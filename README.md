# DecompilingEVMtoC

This  project  is  an  academic  proposal  supervised  by  Martin  Nyx  Brain  and  Michał  Król.  The
project is  a  decompiler  that  converts  EVM  byte  code  into  C  that  can  be
handled by the CPROVER tools


### [How to Compile and run the Decompiler Java program:]()

Requirements:

You must have Java , and the JVM downloaded on your device,
see [https://www.java.com/en/](https://www.java.com/en/)

Visual Code:

![image](https://user-images.githubusercontent.com/38893338/168723994-586de86c-3ad5-4e24-b382-18a0242d84bf.png)
EvmDecompile.java
<img width="454" alt="image" src="https://user-images.githubusercontent.com/38893338/168723933-9d9e18e8-ac67-4081-9012-8a4e6989995f.png">


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

<img width="454" alt="image" src="https://user-images.githubusercontent.com/38893338/168724023-3ad12860-a97c-483e-a157-718c910866a0.png">
