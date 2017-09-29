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

  // Find out whether a list is a palindrome.
  "Problem06 isPalindrome(List[Integer](1, 2, 3, 2, 1))" should "return true" in {
    Problems.Problem06 isPalindrome List[Integer](1, 2, 3, 2, 1) shouldEqual true
  }
  it should "return true when passed empty list" in {
    Problems.Problem06 isPalindrome List[Integer]() shouldEqual true
  }
  it should "return true when passed list with one element" in {
    Problems.Problem06 isPalindrome List[Integer](33) shouldEqual true
  }

  // Flatten a nested list structure.
  "Problem07 flatten(List(List(1, 1), 2, List(3, List(5, 8))))" should "return List(1, 1, 2, 3, 5, 8)" in {
    Problems.Problem07 flatten List(List(1, 1), 2, List(3, List(5, 8))) shouldEqual List(1, 1, 2, 3, 5, 8)
  }
  it should "return List(1,2,3) when passed list(1,2,3)" in {
    Problems.Problem07 flatten List(1,2,3) shouldEqual List(1,2,3) 
  }
  it should "return List() when passed list()" in {
    Problems.Problem07 flatten List() shouldEqual List() 
  }
  it should "return List(1,'a','b',2) when passed List(1, List('a', 'b'), List(4))" in {
    Problems.Problem07 flatten List(List(1, List("a", "b"), List(4))) shouldEqual List(1,"a", "b", 4) 
  }
  "Problem07 flattenUsualWay(List(List(1, 1), 2, List(3, List(5, 8))))" should "return List(1, 1, 2, 3, 5, 8)" in {
    Problems.Problem07 flattenUsualWay List(List(1, 1), 2, List(3, List(5, 8))) shouldEqual List(1, 1, 2, 3, 5, 8)
  }
  
  //Eliminate consecutive duplicates of list elements.
  "Problem08 compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))" should "return List('a, 'b, 'c, 'a, 'd, 'e)" in {
    Problems.Problem08 compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldEqual List('a, 'b, 'c, 'a, 'd, 'e)
  }
  it should "return List(1) when passed List(1)" in {
    Problems.Problem08 compress List(1) shouldEqual List(1) 
  }
  it should "return List() when passed List()" in {
    Problems.Problem08 compress List() shouldEqual List() 
  }
  
  "Problem08 compress2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))" should "return List('a, 'b, 'c, 'a, 'd, 'e)" in {
    Problems.Problem08 compress2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldEqual List('a, 'b, 'c, 'a, 'd, 'e)
  }
  it should "return List(1) when passed List(1)" in {
    Problems.Problem08 compress2 List(1) shouldEqual List(1) 
  }
  it should "return List() when passed List()" in {
    Problems.Problem08 compress2 List() shouldEqual List() 
  }

  "Problem09 pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))" should 
  "return List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))" in {
    Problems.Problem09 pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldEqual List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  }

  "Problem10 encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))" should 
  "return List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))" in {
    Problems.Problem10 encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldEqual List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  }

  "Problem11 encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))" should 
  "return List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))" in {
    Problems.Problem11 encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldEqual List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  }

  // Problem 12 Decode a run-length encoded list.
  "Problem12 decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))" should 
  "return List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)" in {
    Problems.Problem12 decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) shouldEqual List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  }

  // Problem 14 Duplicate the elements of a list.
  "Problem14 duplicate(List('a, 'b, 'c, 'c, 'd))" should 
  "return List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)" in {
    Problems.Problem14 duplicate(List('a, 'b, 'c, 'c, 'd)) shouldEqual List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  }

  // Problem 15 Duplicate the elements of a list a given number of times
  "Problem15 duplicateN(3, List('a, 'b, 'c, 'c, 'd))" should 
  "return List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)" in {
    Problems.Problem15 duplicateN(3, List('a, 'b, 'c, 'c, 'd)) shouldEqual List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
  }

  // Problem 16 Drop every Nth element from a list.
  "Problem16 drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))" should 
  "return List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)" in {
    Problems.Problem16 drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldEqual List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  }
  it should "eturn List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k) for drop(4,x)" in {
    Problems.Problem16 drop(4, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldEqual List('a, 'b, 'c, 'e, 'f, 'g, 'i, 'j, 'k)
  }
  // Problem 17 Split a list into two parts
  "Problem17 split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))" should 
  "return (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))" in {
    Problems.Problem17 split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldEqual (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  }
  // Problem 18 Extract a slice from a list
  "Problem18 slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))" should 
  "return List('d, 'e, 'f, 'g)" in {
    Problems.Problem18 slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldEqual List('d, 'e, 'f, 'g)
  }

}