package com.kevinorr

import org.scalatest._

/**
  * Created by kevinorr on 25/09/2017.
  */
class ProblemsTests extends FlatSpec with Matchers {

  "Problem01 last(List[Integer](1, 1, 2, 3, 5, 8))" should "return 8" in {
    Problems.Problem01 last List[Integer](1, 1, 2, 3, 5, 8) shouldEqual 8
  }
  it should "throw NoSuchElementException for empty list List[Integer]()" in {
    a [NoSuchElementException] should be thrownBy {
      Problems.Problem01 last List[Integer]()
    }
  }
  it should "throw NoSuchElementException for empty list list()" in {
    a [NoSuchElementException] should be thrownBy {
      Problems.Problem01 last List()
    }
  }

  it should "return Some(8) for recurrsive version lastRec(List[Integer](1, 1, 2, 3, 5, 8))" in {
    Problems.Problem01 lastRec List[Integer](1, 1, 2, 3, 5, 8) shouldEqual Some(8)
  }
  it should "return None when lastRec passed empty list" in {
    Problems.Problem01 lastRec List[Integer]() shouldEqual None
  }

  "Problem02 penultimate(List[Integer](1, 1, 2, 3, 5, 8))" should "return Some(5)" in {
    Problems.Problem02 penultimate List[Integer](1, 1, 2, 3, 5, 8) shouldEqual Some(5)
  }
  it should "return None when passed empty list" in {
    Problems.Problem02 penultimate List[Integer]() shouldEqual None
  }

  "Problem03 kth(2, List)" should "return Some(2) for kth(2, List[Integer](1, 1, 2, 3, 5, 8))" in {
    Problems.Problem03.kth(2, List[Integer](1, 1, 2, 3, 5, 8)) shouldEqual Some(2)
  }
  it should "return None when passed empty list" in {
    Problems.Problem03.kth(2, List()) shouldEqual None
  }
  it should "return None when passed kth position greater than list size" in {
    Problems.Problem03.kth(22, List[Integer](1, 1, 2, 3, 5, 8)) shouldEqual None
  }
  it should "return None when passed kth position less than 1" in {
    Problems.Problem03.kth(-22, List[Integer](1, 1, 2, 3, 5, 8)) shouldEqual None
  }

  // Find the number of elements of a list
  "Problem04 length(List[Integer](1, 1, 2, 3, 5, 8))" should "return 6" in {
    Problems.Problem04 length List[Integer](1, 1, 2, 3, 5, 8) shouldEqual 6
  }
  it should "return 0 when passed empty list" in {
    Problems.Problem04 length List[Integer]() shouldEqual 0
  }

  // reverse a list
  "Problem05 reverse(List[Integer](1, 1, 2, 3, 5, 8))" should "return List[Integer](8, 5, 3, 2, 1, 1)" in {
    Problems.Problem05 reverse List[Integer](1, 1, 2, 3, 5, 8) should contain theSameElementsInOrderAs List[Integer](8, 5, 3, 2, 1, 1)
  }
  it should "return 0 when passed empty list" in {
    Problems.Problem05 reverse List[Integer]() shouldEqual List()
  }

}