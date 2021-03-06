import com.github.gekomad.nonemptystring.nonVoidString.{NonEmptyString, NonVoidString}
import org.scalatest.funsuite.AnyFunSuite

class NonEmptyStringTest extends AnyFunSuite {

  test("instantiate test 0") {
    val a: Option[NonEmptyString] = NonEmptyString("foo")
    a.map(s => assert(s.toString == "foo"))
  }

  test("instantiate test 1") {
    val a: Option[NonEmptyString] = NonEmptyString("")
    assert(a.isEmpty)
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

  test("trim test") {
    val a: Option[NonEmptyString] = NonEmptyString(" ")
    assert(a == NonEmptyString(" "))
    val b: Option[NonVoidString] = a.flatMap(a => a.trim)
    assert(b.isEmpty)
  }

  test("concat 1 test") {
    val a: Option[NonEmptyString] = NonEmptyString("foo")
    val b                         = a.map(a => a.concat("bar"))
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
    assert(!a.equals(b))
  }

  test("equal 7 test") {
    val a: Option[NonEmptyString] = NonEmptyString("foo")
    val b                         = "foo"
    a.map { s =>
      assert(s == b)
      assert(s == b)
    }
  }

  test("compare 1 test") {
    val a = for {
      a <- NonEmptyString("f")
      b <- NonEmptyString("F")
    } yield a.compareTo(b)

    assert(a.contains(32))
  }

  test("equalsIgnoreCase test") {
    val a = for {
      a <- NonEmptyString("f")
      b <- NonEmptyString("F")
    } yield a.equalsIgnoreCase(b)

    assert(a.contains(true))
  }

  test("replace test") {
    val bar = NonEmptyString("bar")
    assert(bar.flatMap(_.replace('b', 'a')) == NonEmptyString("aar"))

    val a = NonEmptyString("a")
    assert(a.flatMap(_.replace("a", " ")) == NonEmptyString(" "))
  }

  test("substring test") {
    val a = NonEmptyString("bar")

    assert(a.flatMap(_.substring(1)) == NonEmptyString("ar"))
    assert(a.flatMap(_.substring(3)).isEmpty)
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
