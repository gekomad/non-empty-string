import com.github.gekomad.nonemptystring.NonEmptyString
import org.scalatest.funsuite.AnyFunSuite

class NonEmptyStringTest extends AnyFunSuite {

  test("instantiate test") {
    val a: NonEmptyString         = NonEmptyString('f', "oo")
    val b: Option[NonEmptyString] = NonEmptyString("foo")
    assert(a == NonEmptyString('f', "oo"))
    assert(b == Some(NonEmptyString('f', "oo")))
  }

  test("concat 1 test") {
    val a: NonEmptyString = NonEmptyString('f', "oo")
    val b                 = a.concat("bar")
    assert(b == NonEmptyString('f', "oobar"))
  }

  test("concat 2 test") {
    val a = NonEmptyString('f', "")
    val b = a.concat("bar")
    assert(b == NonEmptyString('f', "bar"))
  }

  test("equal 1 test") {
    val a = NonEmptyString('f', "")
    val b = NonEmptyString('f', "")
    assert(a.equals(b) == true)
  }

  test("equal 2 test") {
    val a = NonEmptyString('f', "")
    val b = NonEmptyString('f', "oo")
    assert(a.equals(b) == false)
  }

  test("equal 3 test") {
    val a = NonEmptyString('f', "oo")
    val b = NonEmptyString('f', "oo")
    assert(a == b)
  }

  test("equal 4 test") {
    val a = NonEmptyString('f', "oo")
    val b = NonEmptyString('f', "")
    assert(a != b)
  }

  test("equal 5 test") {
    val a = NonEmptyString('f', "")
    val b = NonEmptyString('F', "")
    assert(a.equals(b) == false)
  }

  test("equal 6 test") {
    val a = NonEmptyString('f', "")
    val b = "F"
    assert(!(a == b))
    assert(a != b)
  }

  test("equal 7 test") {
    val a = NonEmptyString('f', "oo")
    val b = "foo"
    assert(a == b)
    assert(!(a != b))
  }

  test("compare 1 test") {
    val a = NonEmptyString('f', "")
    val b = NonEmptyString('F', "")
    assert(a.compareTo(b) == 32)
  }

  test("compare 2 test") {
    val a = NonEmptyString('f', "a")
    val b = NonEmptyString('f', "b")
    assert(a.compareTo(b) == -1)
  }

  test("compare 3 test") {
    val a = NonEmptyString('f', "")
    val b = "F"
    assert(a.compareTo(b) == 32)
  }

  test("compare 4 test") {
    val a = NonEmptyString('f', "a")
    val b = "fb"
    assert(a.compareTo(b) == -1)
  }

  test("equalsIgnoreCase test") {
    val a = NonEmptyString('f', "")
    val b = NonEmptyString('F', "")
    assert(a.equalsIgnoreCase(b) == true)
  }

  test("replace test") {
    val a = NonEmptyString('b', "ar")

    assert(a.replace('b', 'a') == NonEmptyString('a', "ar"))
  }

  test("substring test") {
    val a = NonEmptyString('b', "ar")

    assert(a.substring(1) == Some(NonEmptyString('a', "r")))
    assert(a.substring(3) == None)
  }

  test("value of test") {
    assert(NonEmptyString.valueOf(true) == NonEmptyString('t', "rue"))
    assert(NonEmptyString.valueOf(false) == NonEmptyString('f', "alse"))
    assert(NonEmptyString.valueOf('a') == NonEmptyString('a', ""))
    assert(NonEmptyString.valueOf(1.2) == NonEmptyString('1', ".2"))
    assert(NonEmptyString.valueOf(1.2F) == NonEmptyString('1', ".2"))
    assert(NonEmptyString.valueOf(100) == NonEmptyString('1', "00"))
    assert(NonEmptyString.valueOf(200L) == NonEmptyString('2', "00"))
  }

}
