# NonEmptyString type for scala  
 
#### To use the library copy [NoneEmptyString.scala](https://github.com/gekomad/non-empty-string/blob/master/src/main/scala/com/github/gekomad/nonemptystring/NonEmptyString.scala)  to your project.

#### Instantiate  
```scala 
val a: Option[NonEmptyString] = NonEmptyString("foo")  
a.map(s => assert(s.toString == "foo"))  
``` 

```scala 
val a: Option[NonEmptyString] = NonEmptyString("")  
assert(a == None)  
``` 

```scala
val a: Option[NonEmptyString] = NonEmptyString(" ")  
a.map(s => assert(s.toString == " "))  
``` 
#### Instantiate using isBlank
 
```scala
val a: Option[NonBlankString] = NonBlankString(" ")  
assert(a == None)  
``` 

```scala
val a: Option[NonBlankString] = NonBlankString(" \n")  
assert(a == None)  
```   

#### Compare NonEmptyString with NonEmptyString  
  
```scala  
val a = for {  
  a <- NonEmptyString("f")
  b <- NonEmptyString("F")
} yield a.equalsIgnoreCase(b)  
assert(a == Some(true))  
```  
#### Compare NonEmptyString with String  
```scala
val a: Option[NonEmptyString] = NonEmptyString("foo")  
a.map { s =>  
 assert(s == "foo")
}  
```

#### You can applicate String's method to `NonEmptyString.toString` or use these methods   on `NonEmptyString`
```scala
def toString: String   
def charAt(index: Int)   
def codePointAt(index: Int): Int   
def codePointCount(beginIndex: Int, endIndex: Int)   
def compareTo(anotherString: String): Int   
def compareTo(aNonEmptyString: NonEmptyString): Int   
def compareToIgnoreCase(str: String): Int   
def compareToIgnoreCase(aNonEmptyString: NonEmptyString): Int   
def concat(str: String): NonEmptyString   
def concat(aNonEmptyString: NonEmptyString): NonEmptyString   
def contains(cs: CharSequence): Boolean   
def contentEquals(sc: CharSequence): Boolean   
def contentEquals(sb: StringBuffer): Boolean   
def endsWith(suffix: String): Boolean   
def endsWith(suffix: NonEmptyString): Boolean   
def == (that: NonEmptyString): Boolean   
def == (that: String): Boolean   
def != (that: NonEmptyString): Boolean   
def != (that: String): Boolean   
def equalsIgnoreCase(str: String): Boolean   
def equalsIgnoreCase(aNonEmptyString: NonEmptyString): Boolean   
def getBytes(): Array[Byte]   
def getBytes(charset: java.nio.charset.Charset): Array[Byte]   
def getBytes(charsetName: String): Array[Byte]   
def indexOf(ch: Int): Int   
def indexOf(ch: Int, fromIndex: Int): Int   
def indexOf(str: String, fromIndex: Int): Int   
def indexOf(aNonEmptyString: NonEmptyString, fromIndex: Int): Int   
def isEmpty(): Boolean   
def lastIndexOf(ch: Int): Int   
def lastIndexOf(ch: Int, fromIndex: Int): Int   
def lastIndexOf(str: String): Int   
def lastIndexOf(str: String, fromIndex: Int): Int   
def lastIndexOf(aNonEmptyString: NonEmptyString): Int   
def lastIndexOf(aNonEmptyString: NonEmptyString, fromIndex: Int): Int   
def length(): Int   
def matches(regex: String): Boolean   
def offsetByCodePoints(index: Int, codePointOffset: Int): Int   
def regionMatches(ignoreCase: Boolean, toffset: Int, other: String, ooffset: Int, len: Int)   
def regionMatches(toffset: Int, other: String, ooffset: Int, len: Int)   
def replace(oldChar: Char, newChar: Char): NonEmptyString   
def replace(target: CharSequence, replacement: CharSequence): NonEmptyString   
def replaceAll(regex: String, replacement: String): NonEmptyString   
def replaceFirst(regex: String, replacement: String): NonEmptyString   
def split(regex: String): Array[String]   
def split(regex: String, limit: Int): Array[String]   
def startsWith(prefix: String): Boolean   
def startsWith(prefix: String, toffset: Int): Boolean   
def startsWith(prefix: NonEmptyString): Boolean   
def startsWith(prefix: NonEmptyString, toffset: Int): Boolean   
def subSequence(beginIndex: Int, endIndex: Int): CharSequence   
def substring(beginIndex: Int): Option[NonEmptyString]   
def substring(beginIndex: Int, endIndex: Int): Option[NonEmptyString]   
def toCharArray(): Array[Char]   
def toLowerCase()   
def toLowerCase(locale: java.util.Locale)   
def toUpperCase()   
def toUpperCase(locale: java.util.Locale)   
def trim()   
 ``` 
 
 #### Bugs and Feedback For bugs, questions and discussions please use [Github Issues](https://github.com/gekomad/non-empty-string/issues).    
    
## License    
 Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance    
with the License. You may obtain a copy of the License at    
    
[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)    
    
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an    
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.    
See the License for the specific language governing permissions and limitations under the License.
