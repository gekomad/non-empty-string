import com.github.gekomad.NonEmptyString.nonVoidString.{NonBlankString, NonEmptyString}
import org.scalatest.funsuite.AnyFunSuite

class NonBlankStringBlankTest extends AnyFunSuite {

  test("instantiate test 1") {
    val a: Option[NonBlankString] = NonBlankString(" ")
    assert(a == None)
  }

  test("instantiate test 2") {
    val a: Option[NonBlankString] = NonBlankString(" \n")
    assert(a == None)
  }

  test("concat 1 test") {
    val a: Option[NonBlankString] = NonBlankString("foo")
    val b                         = a.map(_.concat(""))
    assert(b == NonBlankString("foo"))
  }

  test("equal 3 test") {
    val a = NonBlankString("foo")
    val b = NonBlankString("foo")
    assert(a == b)
  }

  test("equal 4 test") {
    val a = NonBlankString("foo")
    val b = NonBlankString("bar")
    assert(a != b)
  }

  test("equal 7 test") {
    val a = NonBlankString("foo")
    val b = "foo"
    a.map { s =>
      assert(s == b)
      assert(!(s != b))
    }
  }

  test("compare 1 test") {

    val a = for {
      a <- NonBlankString("f")
      b <- NonBlankString("F")
    } yield a.compareTo(b)

    assert(a == Some(32))
  }

  test("equalsIgnoreCase test") {

    val a = for {
      a <- NonBlankString("f")
      b <- NonBlankString("F")
    } yield a.equalsIgnoreCase(b)

    assert(a == Some(true))
  }

  test("replace test") {
    val bar = NonBlankString("bar")
    assert(bar.flatMap(_.replace('b', 'a')) == NonBlankString("aar"))

    val a = NonBlankString("a")
    assert(a.flatMap(_.replace("a", " ")) == None)

  }

  test("substring test") {
    val a = NonBlankString("bar")

    assert(a.map(_.substring(1)) == Some(NonBlankString("ar")))
    assert(a.flatMap(_.substring(3)) == None)
  }

}
