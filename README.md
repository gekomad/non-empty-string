# NonEmptyString and NonBlankString type for scala  
 
#### To use the library copy [NoneEmptyString.scala](https://github.com/gekomad/non-empty-string/blob/master/src/main/scala/com/github/gekomad/nonemptystring/NonEmptyString.scala)  to your project.

#### NonEmptyString  
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
#### NonBlankString
 
```scala
val a: Option[NonBlankString] = NonBlankString(" ")  
assert(a.isEmpty)  
``` 

```scala
val a: Option[NonBlankString] = NonBlankString(" \n")  
assert(a.isEmpty)  
```   

#### Comparing with String  
```scala
val a: Option[NonEmptyString] = NonEmptyString("foo")  
a.map { s =>  
 assert(s == "foo")
}  
```

#### Converto to String  

```scala
val bar = NonEmptyString("bar")
bar.map { s =>
  assert(s.toString == "bar")
}
```


#### Replacing  
```scala
val bar = NonEmptyString("bar")
assert(bar.flatMap(_.replace('b', 'a')) == NonEmptyString("aar"))

val a = NonEmptyString("a")
assert(a.flatMap(_.replace("a", " ")) == NonEmptyString(" "))

val b = NonBlankString("b")
assert(b.flatMap(_.replace("b", " ")) == None)
```

 
 #### Bugs and Feedback For bugs, questions and discussions please use [Github Issues](https://github.com/gekomad/non-empty-string/issues).    
    
## License    
 Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance    
with the License. You may obtain a copy of the License at    
    
[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)    
    
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an    
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.    
See the License for the specific language governing permissions and limitations under the License.
