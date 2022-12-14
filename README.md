
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

```
<program>-> `begin`<stmt_list>


<stmt_list>-> <stmt> `;` | <stmt> `;` <stmt_list>


<stmt>—> <var_declaration> | <func_declaration> | <assignment> | <expression> | <while_loop> | <switch> | <block>


<block>-> `{` <stmt> `}`


<while_loop>-> `dothiswhile(` <and> `)` <block> 


<switch>-> `isthistrue (` <and> `)` <block> [`ifnot` <block>]


<expression>-> <term> (`*`| `/` | `%` ) <term> | <term>


<term>-> <factor> (`+`| `-`) <factor> | <factor>


<factor>-> `identifier` |`number_lit`|`yorn_lit` | `word_lit` | `decimal_lit`


<var_declaration>-> `declaration_keyword` `identifier`  `;`


<assignment>-> `identifier` `=` <expression> `;`


<func_declaration>-> `function` `identifier` `(` <parameter> `)` <block>


<and>-> <or> `and` <or> | <or>


<or>-> <check_if_equal>  `or` <check_if_equal> | <check_if_equals>


<check_if_equal>-> <check_value> (`not=`|`is=`) <check_value> | <check_value>


<check_value>-> <boolean_expression> (`<=`|`>=`|`<`|`>`) <boolean_expression> | <boolean_expression>


<boolean_expression>-> <boolean_term> (`*`|`/`|`%`) <boolean_term> | <boolean_term>


<boolean_term>-> <boolean_factor> (`+`|`-`) <boolean_factor> | <boolean_factor>


<boolean_factor>-> `identifier` |`number_lit`|`yorn_lit` | `word_lit` | `decimal_lit`

```


## Literals
### Word Rules
```
word word_name = "hello" ;
```
In EZ, a word is an object that represents a sequence of characters.

A word must be enclosed in double quotes (").
A word can contain any number of characters, including numbers and special characters.
Words are case-sensitive, so "hello" and "Hello" are considered to be different words.

### Number & Decimal Rules

```
number number_name = 1 ;
```
```
decimal decimal_name = 1.5 ;
```
Arithmetic operations: The basic arithmetic operations (addition, subtraction, multiplication, and
division) work slightly differently for number and decimal values. For number values, these operations will
always result in an integer value, with any decimal part of the result being truncated. For decimal 
values, these operations will always result in a decimal value, with any decimal part of the result being preserved.

Type conversion: When an number value is assigned to a decimal variable, or vice versa, the value will 
be automatically converted to the appropriate data type. This is called type conversion, and it is 
done automatically by the EZ compiler. For example, Number a = 5; Decimal b = a; will assign the 
value 5 to the number variable a, and then convert that value to a decimal and assign it to the decimal variable b.

Precision: decimal values have greater precision than number values, meaning that they can represent 
a wider range of numbers with greater accuracy. This can be useful when working with decimal values, 
but it can also lead to rounding errors if the precision of a decimal value is not sufficient to represent a number accurately.


### YesOrNo Rules
```
yesorno yorn_name = true ;
```
In EZ, a yesorno is a data type that can have one of two possible values: true or false. It is commonly used to represent a condition that can either be true or false. For example, you might use a yesorno to represent whether a certain condition has been met, or to represent whether a user has entered a valid input.

A yesorno must be declared before it can be used. This is done using the `YesOrNo` keyword, followed by the name of the YesOrNo variable. 

The value of a yesorno can be checked using an `isthistrue` statement. More information on this structure can be found in Structure Rules section

Two booleans can be combined using the `and` and `or` operators.

### Miscellaneous Attribute Grammar Rules
- If a yesorno is assigned to a number variable, the value will be either 1 or 0 (true == 1, false == 0)
- If subtraction is performed on a word, the word will be truncated the number of characters.
- Any other type assigned outside of the declared type will result in semantic error.
## Structure Rules

### Control Structure Rules
```
  isthistrue ( varone is= 123 ) {
  //code to be executed
  } ifnot {
  //code to be executed
  }
``` 
In EZ, an `isthistrue` statement is used to execute a block of code only if a specified condition is true. An `ifnot` statement can be used in conjunction with an if statement to execute a different block of code if the condition is false.

The `isthistrue` statement must be followed by a condition in parentheses. This condition can be any expression that evaluates to a YesOrNo value (i.e. true or false).
The code to be executed if the condition is true must be enclosed in curly braces. 

The `ifnot` statement must be used after an if statement, and it must also be followed by a condition in parentheses. This condition is the opposite of the condition in the if statement.

```
dothiswhile ( varone is= 123 ) {
//code to execute
}
```
`dothiswhile` is a control flow statement that executes a block of code while a yesorno condition is true. The condition must be a yesorno expression, i.e., it must evaluate to either true or false. The condition must be placed inside the parentheses () following the while keyword.

The code to be executed in the loop body must be placed inside the braces {} following the condition. The loop body can contain any valid EZ statements

### Function Rules
  ```
  function function_ name ( Number num ) {
  //code to be executed
  }
  ```
In EZ, a function is a block of code that performs a specific task. Functions can be declared and used in a number of different ways in EZ, but there are a few basic rules that apply to all functions.
  
A function must be declared before it can be used. this is done by using the `function` keyword folowed by the name of the function , and the parameter in parentheses.
  
If a function takes in parameters, you must specify the data type and name of each parameter when declaring the function. 

### Comments

In EZ, there is one way to write comments in your code so that the compiler ignores. Comments should start with `ignoreuntil` your comment text and then `untilhere`

```
ignoreuntil
comment text
untilhere

begin
funtion fun_ction ( )  {

}
```

## Denotational Semantics for Selected Statements
  
 ```
  <switch> -> `isthistrue (` <and> `)` <block> [`ifnot` <block>]
M_s(ifthistrue(<and>) <block>[1] ifnot <block>[2], s)
		if M_b(<and>, s) == error
		return error
		if M_b(<and>, s)
			return M_block(<block>[1], s)
		else return M_block(<block>[2], s)
  ```

```
<while_loop> -> `dothiswhile(` <and> `)` <block> 
M_while (dothiswhile (<and>) <block> =, s)
		if M_b(<and>, s) == error
		return error
		if M_b(<and>, s)
			if M_b(<stmt>, s) ==error
				error
			else s = M_s(<block>, s)
			M_while(dothiswhile (<and>) <block> =, s)		
		else
		return s  
```    
```
<expression> -> <term> (`*`| `/` | `%` ) <term> | <term>
M_e (<expression>, s) == switch(<expression>)
	case <term>[1] *  <term>[2]:
		if M_e(<expression>.term[1], s) == error || M_e(<expression>.term[2], s) == error 
		return error
		if(M_t(<term[1]>).type != M_t(<term[2]>).type)
		return error		
		else return M_t(<term[1]>, s) * M_t (<term[2]>, s)
	case <term>[1] /  <term>[2]:
		if M_e(<expression>.term[1], s) == error || M_e(<expression>.term[2], s) == error 
		return error
		if(M_t(<term[1]>).type != M_t(<term[2]>).type)
		return error		
		else return M_t(<term[1]>, s) / M_t (<term[2]>, s)
	case <term>[1] %  <term>[2]:
		if M_e(<expression>.term[1], s) == error || M_e(<expression>.term[2], s) == error 
		return error
		if(M_t(<term[1]>).type != M_t(<term[2]>).type)
		return error		
		else return M_t(<term[1]>, s) * M_t (<term[2]>, s)
```
	
```
<term> -> <factor> (`+`| `-`) <factor> | <factor>
M_t (<term> ,s )==switch(<term>)
	case <factor>[1] +  <factor>[2]:
		if M_t(<term>.factor[1], s) == error || M_t(<term>.factor[2], s) == error 
		return error
		if(M_t(<factor[1]>).type != M_t(<factor>[2]>).type)
		return error
		else return M_f (<factor[1]>, s) + M_f (<factor[2]>, s)
	case <factor>[1] -  <factor>[2]:
		if M_t(<term>.factor[1], s) == error || M_t(<term>.factor[2], s) == error 
		return error
		if(M_f(<factor[1]>).type != M_f(<factor[2]>).type)
		return error
		else return M_f (<factor[1]>, s) - M_f (<factor[2]>, s)
	
```

```	
<factor> -> identifier | `number`| `decimal` | `word` | 
M_f(<factor>, s) == switch (<factor>)
	case <var> if VARMAP(<var>, s)==undefined
		then error
		else return VARMAP (<var>, s)
	case <num_lit>
		return <num_lit>.value
	case <dec_lit>
		return <dec_lit>.value
	case <word>
		return <word>.value

```
	
```	
<and> -> <or> `and` <or> | <or>
M_bool_e (<bool_expression>, s) == switch(<bool_expression>)
	case <boolterm>[1] *  <boolterm>[2]:
		if M_bool_e(<bool_expression>.term[1], s) == error || M_e(<bool_expression>.term[2], s) == error 
		return error		
		else return M_bool_t(<bool_term[1]>, s) * M_bool_t (<bool_term[2]>, s)
	case <boolterm>[1] /  <boolterm>[2]:
		if M_bool_e(<bool_expression>.term[1], s) == error || M_e(<bool_expression>.term[2], s) == error 
		return error		
		else return M_bool_t(<bool_term[1]>, s) / M_bool_t (<bool_term[2]>, s)
	case <boolterm>[1] %  <boolterm>[2]:
		if M_bool_e(<bool_expression>.term[1], s) == error || M_e(<bool_expression>.term[2], s) == error 
		return error		
		else return M_bool_t(<bool_term[1]>, s) % M_bool_t (<bool_term[2]>, s)
	case <boolterm>
		if M_bool_e(<bool_expression>.term, s) == error  
		return error		
		else return M_bool_t(<bool_term>, s)```	
```	

```
M_bool_t (<bool_term> ,s )==switch(<term>)
	case <bool_factor>[1] +  <bool_factor>[2]:
		if M_bool_t(<term>.factor[1], s) == error || M_bool_t(<term>.factor[2], s) == error 
		return error
		if(M_bool_t(<factor[1]>).type != M_bool_t(<factor>[2]>).type)
		return error
		else return M_bool_f (<bool_factor[1]>, s) + M_bool_f (<bool_factor[2]>, s)
	case <bool_factor>[1] -  <factor>[2]:
		if M_bool_t(<term>.factor[1], s) == error || M_bool_t(<term>.factor[2], s) == error 
		return error
		if(M_bool_t(<factor[1]>).type != M_bool_t(<factor>[2]>).type)
		return error
		else return M_bool_f (<bool_factor[1]>, s) - M_bool_f (<bool_factor[2]>, s)
	case <bool_factor>
		return M_bool_f(<bool_factor>, s)	
```	

```	
<boolean_factor>-> identifier | <yesorno>
M_bool_f(<fbool_actor>, s) == switch (<factor>)
	return s```	

```	

