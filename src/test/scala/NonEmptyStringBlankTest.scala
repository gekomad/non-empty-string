import com.github.gekomad.nonemptystring.NonEmptyString
import org.scalatest.funsuite.AnyFunSuite

class NonEmptyStringBlankTest extends AnyFunSuite {

  test("instantiate test 1") {
    val a: Option[NonEmptyString] = NonEmptyString(" ", isBlank = true)
    assert(a == None)
  }

  test("instantiate test 2") {
    val a: Option[NonEmptyString] = NonEmptyString(" \n", isBlank = true)
    assert(a == None)
  }

  test("concat 1 test") {
    val a: Option[NonEmptyString] = NonEmptyString("foo", isBlank = true)
    val b: Option[NonEmptyString] = a.map(_.concat(""))
    assert(b == NonEmptyString("foo"))
  }

  test("equal 3 test") {
    val a = NonEmptyString("foo", isBlank = true)
    val b = NonEmptyString("foo", isBlank = true)
    assert(a == b)
  }

  test("equal 4 test") {
    val a = NonEmptyString("foo", isBlank = true)
    val b = NonEmptyString("bar", isBlank = true)
    assert(a != b)
  }

  test("equal 7 test") {
    val a = NonEmptyString("foo", isBlank = true)
    val b = "foo"
    a.map { s =>
      assert(s == b)
      assert(!(s != b))
    }
  }

  test("compare 1 test") {

    val a = for {
      a <- NonEmptyString("f", isBlank = true)
      b <- NonEmptyString("F", isBlank = true)
    } yield a.compareTo(b)

    assert(a == Some(32))
  }

  test("equalsIgnoreCase test") {

    val a = for {
      a <- NonEmptyString("f", isBlank = true)
      b <- NonEmptyString("F", isBlank = true)
    } yield a.equalsIgnoreCase(b)

    assert(a == Some(true))
  }

  test("replace test") {
    val a = NonEmptyString("bar", isBlank = true)
    assert(a.map(_.replace('b', 'a')) == NonEmptyString("aar"))
  }

  test("substring test") {
    val a = NonEmptyString("bar", isBlank = true)

    assert(a.map(_.substring(1)) == Some(NonEmptyString("ar")))
    assert(a.flatMap(_.substring(3)) == None)
  }

}
