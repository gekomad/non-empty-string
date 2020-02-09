import com.github.gekomad.nonemptystring.NonEmptyString
import org.scalatest.funsuite.AnyFunSuite

class NonEmptyStringTest extends AnyFunSuite {

  test("instantiate test 0") {
    val a: Option[NonEmptyString] = NonEmptyString("foo")
    a.map(s => assert(s.toString == "foo"))
  }

  test("instantiate test 1") {
    val a: Option[NonEmptyString] = NonEmptyString("")
    assert(a == None)
    val b: Option[NonEmptyString] = NonEmptyString(" ")
    b.map { s =>
      assert(s.toString == " ")
    }
  }

  test("instantiate test 2") {
    val a: Option[NonEmptyString] = NonEmptyString("foo")
    a.map(s => assert(s.toString == "foo"))
    val b: Option[NonEmptyString] = NonEmptyString("foo")
    assert(a == b)
  }

  test("concat 1 test") {
    val a: Option[NonEmptyString] = NonEmptyString("foo")
    val b: Option[NonEmptyString] = a.map(_.concat("bar"))
    assert(b == NonEmptyString("foobar"))
  }

  test("equal 3 test") {
    val a = NonEmptyString("foo")
    val b = NonEmptyString("foo")
    assert(a == b)
  }

  test("equal 4 test") {
    val a = NonEmptyString("foo")
    val b = NonEmptyString("bar")
    assert(a != b)
  }

  test("equal 5 test") {
    val a = NonEmptyString("foo")
    val b = NonEmptyString("FOO")
    assert(a.equals(b) == false)
  }

  test("equal 7 test") {
    val a: Option[NonEmptyString] = NonEmptyString("foo")
    val b                         = "foo"
    a.map { s =>
      assert(s == b)
      assert(!(s != b))
    }
  }

  test("compare 1 test") {
    val a = for {
      a <- NonEmptyString("f")
      b <- NonEmptyString("F")
    } yield a.compareTo(b)

    assert(a == Some(32))
  }

  test("equalsIgnoreCase test") {

    val a = for {
      a <- NonEmptyString("f")
      b <- NonEmptyString("F")
    } yield a.equalsIgnoreCase(b)

    assert(a == Some(true))
  }

  test("replace test") {
    val a = NonEmptyString("bar")
    assert(a.map(_.replace('b', 'a')) == NonEmptyString("aar"))
  }

  test("substring test") {
    val a = NonEmptyString("bar")

    assert(a.map(_.substring(1)) == Some(NonEmptyString("ar")))
    assert(a.flatMap(_.substring(3)) == None)
  }

  test("value of test") {
    assert(NonEmptyString.valueOf(true) == NonEmptyString("true").get)
    assert(NonEmptyString.valueOf(false) == NonEmptyString("false").get)
    assert(NonEmptyString.valueOf('a') == NonEmptyString("a").get)
    assert(NonEmptyString.valueOf(1.2) == NonEmptyString("1.2").get)
    assert(NonEmptyString.valueOf(1.2F) == NonEmptyString("1.2").get)
    assert(NonEmptyString.valueOf(100) == NonEmptyString("100").get)
    assert(NonEmptyString.valueOf(200L) == NonEmptyString("200").get)
  }

}
