
# EZ Programming Language

My new programming language "EZ" is designed to be a simple and intuitive tool for students to use when learning the art of programming. It features a clean syntax library, making it easy to write programs that are both efficient and readable for beginners. 
While learning how to code, I had a hard time visualizing what the code was doing, based off of abstract keywords and method calls, some of which i had first heard of in that class. This program's simplicity seeks to solve that by using plain english and a 
more logical why of describing and declaring language actions.

Some of the notable features of the language include:

Support for a variety of data types, including integer numbers, real numbers, strings, and booleans, with intuitive declarations.
A wide range of operators for performing arithmetic, logical, and assignment operations
Control structures for conditional execution and looping
Built-in support for defining and calling functions

With these features, my programming language is well-suited for a variety of levels of learning, from beginners and intermediate, to programmers dusting off their skills.

## Symbols & Structure Grammars

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

<program> -> begin<stmt_list>

<stmt_list< -> <stmt> ; | <stmt> ; <stmt_list>

<stmt> —> <var_declaration> | <func_declaration> | <assignment> | <expression> | <while_loop> | <switch> | <block>

<block> -> `{` <stmt> `}`

<while_loop> -> `dothiswhile(` <and> `)` <block> 

<switch> -> `isthistrue (` <and> `)` <block> [`ifnot` <block>]

<expression> -> <term> (`*`| `/` | `%` ) <term> | <term>

<term> -> <factor> (`+`| `-`) <factor> | <factor>

<factor> -> identifier |`number_lit`|`yorn_lit` | `word_lit` | `decimal_lit`

<var_declaration> -> declaration_keyword identifier  `;`

<assignment> -> identifier `=` <expression> `;`

<func_declaration> -> `function` identifier `(` <parameter> `)` <block>

<and> -> <or> `and` <or> | <or>

<or> -> <check_if_equal>  `or` <check_if_equal> | <check_if_equals>

<check_if_equal> -> <check_value> (`not=`|`is=`) <check_value> | <check_value>

<check_value> -> <boolean_expression> (`<=`|`>=`|`<`|`>`) <boolean_expression> | <boolean_expression>

<boolean_expression> -> <boolean_term> (`*`|`/`|`%`) <boolean_term> | <boolean_term>

<boolean_term> -> <boolean_factor> (`+`|`-`) <boolean_factor> | <boolean_factor>

<boolean_factor>-> identifier |`number_lit`|`yorn_lit` | `word_lit` | `decimal_lit`


