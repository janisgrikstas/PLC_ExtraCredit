
# EZ Programming Language

My new programming language "EZ" is designed to be a simple and intuitive tool for students to use when learning the art of programming. It features a clean syntax library, making it easy to write programs that are both efficient and readable for beginners. 
While learning how to code, I had a hard time visualizing what the code was doing, based off of abstract keywords and method calls, some of which i had first heard of in that class. This program's simplicity seeks to solve that by using plain english and a 
more logical why of describing and declaring language actions.

Some of the notable features of the language include:

- Support for a variety of data types, including integer numbers, real numbers, strings, and booleans, with intuitive declarations.
- A wide range of operators for performing arithmetic, logical, and assignment operations
- Control structures for conditional execution and looping
- Built-in support for defining and calling functions

With these features, my programming language is well-suited for a variety of levels of learning, from beginners and intermediate, to programmers dusting off their skills.

## Symbols 

dec_lit ->"[+-]?\\d+\\.\\d+"

num_lit -> "[+-]?\\d+"

yorn_lit -> “true” | “false”

word_lit -> "\"(\\\\[\\s\\S]|[^\"])*\""

symbol -> ( // opening parentheses, breaking precedence for mathematical operations

symbol -> ) // closing parentheses

symbol -> { // opening bracket

symbol -> } // closing bracket

symbol -> ; // statement ender

symbol -> , // parameter seperator

identifier -> [A-Za-z][A-Za-z][A-Za-z][A-Za-z][A-Za-z][A-Za-z][A-Za-z]?[A-Za-z]?

operator -> + //addition 

operator -> - //subtraction

operator -> * //multiplication

operator -> / //division

operator ->  = //assignment

bool_operator -> and // && operator **

bool_operator -> or // || operator **

bool_operator -> is= // is equal to (==) **

bool_operator -> < // less than

bool_operator -> > // greater than

bool_operator -> <= // less than or equal to

bool_operator -> >= // greater than or equal to

bool_operator -> not= // not equal to **

key word -> `dothiswhile` while loop  **

key word -> `begin` //program starter

key word -> `isthistrue` //switch

key word -> `ifnot` //else

keyword -> 'say' //prints the following string 

declaration_keywords -> `number` //int**

declaration_keywords -> `word` //string**

declaration_keywords -> `yesorno` //boolean**

declaration_keywords -> `decimal` //double**



## Syntax Grammar Rules

<program> -> `begin`<stmt_list>

<stmt_list< -> <stmt> `;` | <stmt> `;` <stmt_list>

<stmt> —> <var_declaration> | <func_declaration> | <assignment> | <expression> | <while_loop> | <switch> | <block>

<block> -> `{` <stmt> `}`

<while_loop> -> `dothiswhile(` <and> `)` <block> 

<switch> -> `isthistrue (` <and> `)` <block> [`ifnot` <block>]

<expression> -> <term> (`*`| `/` | `%` ) <term> | <term>

<term> -> <factor> (`+`| `-`) <factor> | <factor>

<factor> -> `identifier` |`number_lit`|`yorn_lit` | `word_lit` | `decimal_lit`

<var_declaration> -> `declaration_keyword` `identifier`  `;`

<assignment> -> `identifier` `=` <expression> `;`

<func_declaration> -> `function` `identifier` `(` <parameter> `)` <block>

<and> -> <or> `and` <or> | <or>

<or> -> <check_if_equal>  `or` <check_if_equal> | <check_if_equals>

<check_if_equal> -> <check_value> (`not=`|`is=`) <check_value> | <check_value>

<check_value> -> <boolean_expression> (`<=`|`>=`|`<`|`>`) <boolean_expression> | <boolean_expression>

<boolean_expression> -> <boolean_term> (`*`|`/`|`%`) <boolean_term> | <boolean_term>

<boolean_term> -> <boolean_factor> (`+`|`-`) <boolean_factor> | <boolean_factor>

<boolean_factor>-> `identifier` |`number_lit`|`yorn_lit` | `word_lit` | `decimal_lit`



## Literals
### Word Rules
```
Word word_name = "hello" ;
```
In EZ, a string is an object that represents a sequence of characters.

A string must be enclosed in double quotes (").
A string can contain any number of characters, including numbers and special characters.
Strings are case-sensitive, so "hello" and "Hello" are considered to be different strings.

### Number & Decimal Rules

```
Number number_name = 1 ;
```
```
Decimal decimal_name = 1.5 ;
```
Arithmetic operations: The basic arithmetic operations (addition, subtraction, multiplication, and
division) work slightly differently for number and decimal values. For number values, these operations will
always result in an integer value, with any decimal part of the result being truncated. For decimal 
values, these operations will always result in a decimal value, with any decimal part of the result being preserved.

Type conversion: When an number value is assigned to a decimal variable, or vice versa, the value will 
be automatically converted to the appropriate data type. This is called type conversion, and it is 
done automatically by the EZ compiler. For example, Number a = 5; Decimal b = a; will assign the 
value 5 to the number variable a, and then convert that value to a decimal and assign it to the decimal variable b.

Precision: double values have greater precision than int values, meaning that they can represent 
a wider range of numbers with greater accuracy. This can be useful when working with decimal values, 
but it can also lead to rounding errors if the precision of a double value is not sufficient to represent a number accurately.


### YesOrNo Rules
```
YesOrNo yorn_name = true ;
```
In EZ, a boolean is a data type that can have one of two possible values: true or false. It is commonly used to represent a condition that can either be true or false. For example, you might use a boolean to represent whether a certain condition has been met, or to represent whether a user has entered a valid input.

A YesOrNo must be declared before it can be used. This is done using the `YesOrNo` keyword, followed by the name of the YesOrNo variable. 

The value of a boolean can be checked using an `isthistrue` statement. More information on this structure can be found in Structure Rules section

Two booleans can be combined using the `and` and `or` operators.
## Structure Rules

### Control Structure Rules

In EZ, an `ifthisistrue` statement is used to execute a block of code only if a specified condition is true. An else statement can be used in conjunction with an if statement to execute a different block of code if the condition is false.

The if statement must be followed by a condition in parentheses. This condition can be any expression that evaluates to a YesOrNo value (i.e. true or false).
The code to be executed if the condition is true must be enclosed in curly braces. 

The else statement must be used after an if statement, and it must also be followed by a condition in parentheses. This condition is the opposite of the condition in the if statement. For example:
### Function Rules
