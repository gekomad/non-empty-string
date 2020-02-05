package com.github.gekomad.nonemptystring

/**
  * NonEmptyString
  * https://github.com/gekomad/non-empty-string
  * @author Giuseppe Cannella
  * @since 0.0.1
  */
object NonEmptyString {
  def apply(s: String): Option[NonEmptyString] = if (s.isEmpty) None else Some(NonEmptyString(s.head, s.tail))

  def valueOf(b: Boolean) = NonEmptyString(String.valueOf(b)).get
  def valueOf(b: Char)    = NonEmptyString(String.valueOf(b)).get
  def valueOf(d: Double)  = NonEmptyString(String.valueOf(d)).get
  def valueOf(f: Float)   = NonEmptyString(String.valueOf(f)).get
  def valueOf(i: Int)     = NonEmptyString(String.valueOf(i)).get
  def valueOf(l: Long)    = NonEmptyString(String.valueOf(l)).get
}

final case class NonEmptyString(head: Char, tail: String) {
  private val string = s"$head$tail"

  override def toString: String = string

  @inline def charAt(index: Int)                              = string.charAt(index)
  @inline def codePointAt(index: Int): Int                    = string.codePointAt(index)
  @inline def codePointCount(beginIndex: Int, endIndex: Int)  = string.codePointCount(beginIndex, endIndex)
  @inline def compareTo(anotherString: String): Int           = string.compareTo(anotherString)
  @inline def compareTo(aNonEmptyString: NonEmptyString): Int = string.compareTo(aNonEmptyString.string)
  @inline def compareToIgnoreCase(str: String): Int           = string.compareToIgnoreCase(str)
  @inline def compareToIgnoreCase(aNonEmptyString: NonEmptyString): Int =
    string.compareToIgnoreCase(aNonEmptyString.string)
  @inline def concat(str: String): NonEmptyString = NonEmptyString(head, s"$tail$str")
  @inline def concat(aNonEmptyString: NonEmptyString): NonEmptyString =
    NonEmptyString(head, s"$tail${aNonEmptyString.string}")
  @inline def contains(cs: CharSequence): Boolean       = string.contains(cs)
  @inline def contentEquals(sc: CharSequence): Boolean  = string.contentEquals(sc)
  @inline def contentEquals(sb: StringBuffer): Boolean  = string.contentEquals(sb)
  @inline def endsWith(suffix: String): Boolean         = string.endsWith(suffix)
  @inline def endsWith(suffix: NonEmptyString): Boolean = string.endsWith(suffix.string)
  def ==(that: NonEmptyString): Boolean                 = this.equals(that)
  def ==(that: String): Boolean                         = this.equals(that)
  def !=(that: NonEmptyString): Boolean                 = !this.equals(that)
  def !=(that: String): Boolean                         = !this.equals(that)
  override def equals(that: Any): Boolean = that match {
    case x: NonEmptyString => x.string == this.string
    case x: String         => x == this.string
    case _                 => false
  }

  @inline def equalsIgnoreCase(str: String): Boolean = str.toLowerCase == this.string.toLowerCase

  @inline def equalsIgnoreCase(aNonEmptyString: NonEmptyString): Boolean =
    aNonEmptyString.string.toLowerCase == this.string.toLowerCase

  @inline def getBytes(): Array[Byte]                                  = string.getBytes()
  @inline def getBytes(charset: java.nio.charset.Charset): Array[Byte] = string.getBytes(charset)
  @inline def getBytes(charsetName: String): Array[Byte]               = string.getBytes(charsetName)
  @inline def indexOf(ch: Int): Int                                    = string.indexOf(ch)
  @inline def indexOf(ch: Int, fromIndex: Int): Int                    = string.indexOf(ch, fromIndex)
  @inline def indexOf(str: String, fromIndex: Int): Int                = string.indexOf(str, fromIndex)
  @inline def indexOf(aNonEmptyString: NonEmptyString, fromIndex: Int): Int =
    string.indexOf(aNonEmptyString.string, fromIndex)
  @inline def isEmpty(): Boolean                            = string.isEmpty()
  @inline def lastIndexOf(ch: Int): Int                     = string.lastIndexOf(ch)
  @inline def lastIndexOf(ch: Int, fromIndex: Int): Int     = string.lastIndexOf(ch, fromIndex)
  @inline def lastIndexOf(str: String): Int                 = string.lastIndexOf(str)
  @inline def lastIndexOf(str: String, fromIndex: Int): Int = string.lastIndexOf(str, fromIndex)

  @inline def lastIndexOf(aNonEmptyString: NonEmptyString): Int = string.lastIndexOf(aNonEmptyString.string)
  @inline def lastIndexOf(aNonEmptyString: NonEmptyString, fromIndex: Int): Int =
    string.lastIndexOf(aNonEmptyString.string, fromIndex)

  @inline def length(): Int                   = string.length()
  @inline def matches(regex: String): Boolean = string.matches(regex)
  @inline def offsetByCodePoints(index: Int, codePointOffset: Int): Int =
    string.offsetByCodePoints(index, codePointOffset)
  @inline def regionMatches(ignoreCase: Boolean, toffset: Int, other: String, ooffset: Int, len: Int) =
    string.regionMatches(ignoreCase, toffset, other, ooffset, len)
  @inline def regionMatches(toffset: Int, other: String, ooffset: Int, len: Int) =
    string.regionMatches(toffset, other, ooffset, len)

  @inline def replace(oldChar: Char, newChar: Char): NonEmptyString =
    NonEmptyString(string.replace(oldChar, newChar)).get

  @inline def replace(target: CharSequence, replacement: CharSequence): NonEmptyString =
    NonEmptyString(string.replace(target, replacement)).get

  @inline def replaceAll(regex: String, replacement: String): NonEmptyString =
    NonEmptyString(string.replace(regex, replacement)).get

  @inline def replaceFirst(regex: String, replacement: String): NonEmptyString =
    NonEmptyString(string.replaceFirst(regex, replacement)).get

  @inline def split(regex: String): Array[String]             = string.split(regex)
  @inline def split(regex: String, limit: Int): Array[String] = string.split(regex, limit)

  @inline def startsWith(prefix: String): Boolean               = string.startsWith(prefix)
  @inline def startsWith(prefix: String, toffset: Int): Boolean = string.startsWith(prefix, toffset)

  @inline def startsWith(prefix: NonEmptyString): Boolean               = string.startsWith(prefix.string)
  @inline def startsWith(prefix: NonEmptyString, toffset: Int): Boolean = string.startsWith(prefix.string, toffset)

  @inline def subSequence(beginIndex: Int, endIndex: Int): CharSequence = string.subSequence(beginIndex, endIndex)
  @inline def substring(beginIndex: Int): Option[NonEmptyString]        = NonEmptyString(string.substring(beginIndex))
  @inline def substring(beginIndex: Int, endIndex: Int): Option[NonEmptyString] =
    NonEmptyString(string.substring(beginIndex, endIndex))

  @inline def toCharArray(): Array[Char] = string.toCharArray()

  @inline def toLowerCase()                         = NonEmptyString(string.toLowerCase()).get
  @inline def toLowerCase(locale: java.util.Locale) = NonEmptyString(string.toLowerCase(locale)).get

  @inline def toUpperCase()                         = NonEmptyString(string.toUpperCase()).get
  @inline def toUpperCase(locale: java.util.Locale) = NonEmptyString(string.toUpperCase(locale)).get

  @inline def trim() = NonEmptyString(string.trim()).get

}
