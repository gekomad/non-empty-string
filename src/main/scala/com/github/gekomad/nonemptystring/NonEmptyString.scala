package com.github.gekomad.NonEmptyString
package nonVoidString
import java.lang.Character._

/**
 * NonEmptyString
 * https://github.com/gekomad/non-empty-string
 * @author Giuseppe Cannella
 */
object NonBlankString {
  def apply(s: String): Option[NonBlankString] =
    if (s.replaceAll(s"""[$SPACE_SEPARATOR, $LINE_SEPARATOR, $PARAGRAPH_SEPARATOR,${'\t'} , ${'\n'}, ${'\u000B'},
                        |${'\f'}, ${'\r'}, ${'\u001C'}, ${'\u001D'}, ${'\u001E'}, ${'\u001F'}]""".stripMargin, "")
      .isEmpty)
      None
    else Some(new NonBlankString(s))

}

object NonEmptyString {
  def apply(s: String): Option[NonEmptyString] = if (s.isEmpty) None else Some(new NonEmptyString(s))

  def valueOf(b: Boolean): NonEmptyString = new NonEmptyString(String.valueOf(b))
  def valueOf(b: Char): NonEmptyString    = new NonEmptyString(String.valueOf(b))
  def valueOf(d: Double): NonEmptyString  = new NonEmptyString(String.valueOf(d))
  def valueOf(f: Float): NonEmptyString   = new NonEmptyString(String.valueOf(f))
  def valueOf(i: Int): NonEmptyString     = new NonEmptyString(String.valueOf(i))
  def valueOf(l: Long): NonEmptyString    = new NonEmptyString(String.valueOf(l))
}

class NonEmptyString private (private val string: String) extends NonVoidString(string, false)
class NonBlankString private (private val string: String) extends NonVoidString(string, true)

class NonVoidString private[nonVoidString] (private val string: String, private val checkEmpty: Boolean) {
  override def toString: String = string
  @inline def compareToIgnoreCase(aNonVoidString: NonVoidString): Int =
    string.compareToIgnoreCase(aNonVoidString.string)
  @inline def concat(str: String): NonVoidString =
    if (checkEmpty) NonEmptyString(s"$string$str").get else NonBlankString(s"$string$str").get

  @inline def concat(aNonVoidString: NonVoidString): NonVoidString =
    if (checkEmpty) NonEmptyString(s"string${aNonVoidString.string}").get
    else NonBlankString(s"string${aNonVoidString.string}").get

  def ==(that: NonVoidString): Boolean = this.equals(that)
  def ==(that: String): Boolean        = this.equals(that)
  def !=(that: NonVoidString): Boolean = !this.equals(that)
  def !=(that: String): Boolean        = !this.equals(that)
  override def equals(that: Any): Boolean = that match {
    case x: NonVoidString => x.string == this.string
    case x: String        => x == this.string
    case _                => false
  }

  @inline def contains(cs: CharSequence): Boolean                       = string.contains(cs)
  @inline def contentEquals(sc: CharSequence): Boolean                  = string.contentEquals(sc)
  @inline def contentEquals(sb: StringBuffer): Boolean                  = string.contentEquals(sb)
  @inline def endsWith(suffix: String): Boolean                         = string.endsWith(suffix)
  @inline def endsWith(suffix: NonVoidString): Boolean                  = string.endsWith(suffix.string)
  @inline def charAt(index: Int): Char                                  = string.charAt(index)
  @inline def codePointAt(index: Int): Int                              = string.codePointAt(index)
  @inline def codePointCount(beginIndex: Int, endIndex: Int): Int       = string.codePointCount(beginIndex, endIndex)
  @inline def compareTo(anotherString: String): Int                     = string.compareTo(anotherString)
  @inline def compareTo(aNonVoidString: NonVoidString): Int             = string.compareTo(aNonVoidString.string)
  @inline def compareToIgnoreCase(str: String): Int                     = string.compareToIgnoreCase(str)
  @inline def equalsIgnoreCase(str: String): Boolean                    = str.toLowerCase == this.string.toLowerCase
  @inline def getBytes: Array[Byte]                                     = string.getBytes()
  @inline def getBytes(charset: java.nio.charset.Charset): Array[Byte]  = string.getBytes(charset)
  @inline def getBytes(charsetName: String): Array[Byte]                = string.getBytes(charsetName)
  @inline def indexOf(ch: Int): Int                                     = string.indexOf(ch)
  @inline def indexOf(ch: Int, fromIndex: Int): Int                     = string.indexOf(ch, fromIndex)
  @inline def indexOf(str: String, fromIndex: Int): Int                 = string.indexOf(str, fromIndex)
  @inline def isEmpty: Boolean                                          = string.isEmpty
  @inline def lastIndexOf(ch: Int): Int                                 = string.lastIndexOf(ch)
  @inline def lastIndexOf(ch: Int, fromIndex: Int): Int                 = string.lastIndexOf(ch, fromIndex)
  @inline def lastIndexOf(str: String): Int                             = string.lastIndexOf(str)
  @inline def lastIndexOf(str: String, fromIndex: Int): Int             = string.lastIndexOf(str, fromIndex)
  @inline def split(regex: String): Array[String]                       = string.split(regex)
  @inline def split(regex: String, limit: Int): Array[String]           = string.split(regex, limit)
  @inline def startsWith(prefix: String): Boolean                       = string.startsWith(prefix)
  @inline def startsWith(prefix: String, toffset: Int): Boolean         = string.startsWith(prefix, toffset)
  @inline def startsWith(prefix: NonVoidString): Boolean                = string.startsWith(prefix.string)
  @inline def startsWith(prefix: NonVoidString, toffset: Int): Boolean  = string.startsWith(prefix.string, toffset)
  @inline def subSequence(beginIndex: Int, endIndex: Int): CharSequence = string.subSequence(beginIndex, endIndex)
  @inline def lastIndexOf(aNonVoidString: NonVoidString): Int           = string.lastIndexOf(aNonVoidString.string)
  @inline def length(): Int                                             = string.length()
  @inline def matches(regex: String): Boolean                           = string.matches(regex)
  @inline def equalsIgnoreCase(aNonVoidString: NonVoidString): Boolean =
    aNonVoidString.string.toLowerCase == this.string.toLowerCase
  @inline def indexOf(aNonVoidString: NonVoidString, fromIndex: Int): Int =
    string.indexOf(aNonVoidString.string, fromIndex)
  @inline def lastIndexOf(aNonVoidString: NonVoidString, fromIndex: Int): Int =
    string.lastIndexOf(aNonVoidString.string, fromIndex)
  @inline def offsetByCodePoints(index: Int, codePointOffset: Int): Int =
    string.offsetByCodePoints(index, codePointOffset)
  @inline def regionMatches(ignoreCase: Boolean, toffset: Int, other: String, ooffset: Int, len: Int): Boolean =
    string.regionMatches(ignoreCase, toffset, other, ooffset, len)
  @inline def regionMatches(toffset: Int, other: String, ooffset: Int, len: Int): Boolean =
    string.regionMatches(toffset, other, ooffset, len)
  @inline def replace(oldChar: Char, newChar: Char): Option[NonVoidString] =
    if (checkEmpty) NonEmptyString(string.replace(oldChar, newChar))
    else NonBlankString(string.replace(oldChar, newChar))
  @inline def replace(target: CharSequence, replacement: CharSequence): Option[NonVoidString] =
    if (checkEmpty) NonEmptyString(string.replace(target, replacement))
    else NonBlankString(string.replace(target, replacement))
  @inline def replaceAll(regex: String, replacement: String): Option[NonVoidString] =
    if (checkEmpty) NonEmptyString(string.replace(regex, replacement))
    else NonBlankString(string.replace(regex, replacement))
  @inline def replaceFirst(regex: String, replacement: String): Option[NonVoidString] =
    if (checkEmpty) NonEmptyString(string.replaceFirst(regex, replacement))
    else NonBlankString(string.replaceFirst(regex, replacement))
  @inline def substring(beginIndex: Int): Option[NonVoidString] =
    if (checkEmpty) NonEmptyString(string.substring(beginIndex)) else NonBlankString(string.substring(beginIndex))
  @inline def substring(beginIndex: Int, endIndex: Int): Option[NonVoidString] =
    if (checkEmpty) NonEmptyString(string.substring(beginIndex, endIndex))
    else NonBlankString(string.substring(beginIndex, endIndex))
  @inline def toCharArray: Array[Char] = string.toCharArray
  @inline def toLowerCase: NonVoidString =
    if (checkEmpty) NonEmptyString(string.toLowerCase()).get else NonBlankString(string.toLowerCase()).get
  @inline def toLowerCase(locale: java.util.Locale): NonVoidString =
    if (checkEmpty) NonEmptyString(string.toLowerCase(locale)).get else NonBlankString(string.toLowerCase(locale)).get
  @inline def toUpperCase: NonVoidString =
    if (checkEmpty) NonEmptyString(string.toUpperCase).get else NonBlankString(string.toUpperCase).get
  @inline def toUpperCase(locale: java.util.Locale): NonVoidString =
    if (checkEmpty) NonEmptyString(string.toUpperCase(locale)).get else NonBlankString(string.toUpperCase(locale)).get
  @inline def trim(): Option[NonVoidString] =
    if (checkEmpty) NonEmptyString(string.trim()) else NonBlankString(string.trim())

}
