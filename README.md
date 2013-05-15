PJP_project
===========
CHANGES:
14.5.2013
  - Class utils.Error renamed to MyError -> all references renamed in utils package (see MyError.java file)
  - Added - MyClass.java
  - Added - DeclarationStatement.java


==========
TO DO:
Project.jj:
  - add statement branch (while do, if else) - complete (14.5.2013)
  - add Line and column counter - complete (14.5.2013)
  - correct Literal creation (add right value, not only string) - complete (14.5.2013)
  - add Print and read statement - complete (14.5.2013)
  - add File reading and creating Assembler code file

Other Classes:
  - implements all type checking methods
  - Declare and implement code generating methods

Parsable source code `c-like_source.c`
``` c
int a;
a=5;
int c;
read a;
print c;
float b;
c = 6;

b = a - 1 ;
b = a + c;
//f = -f;
//a = !a;
```
