package com.kevinorr

import scala.annotation.tailrec
/**
http://aperiodic.net/phil/scala/s-99/
*/
object Problems extends App {
  
  // Prob 1 Find the last element of a list.
  object Problem01 {
    def last[T](list: List[T]) : T = list last

    def lastRec[T](list: List[T]) : Option[T] = list match {
      case x :: Nil  => Some(x)
      case x :: rest => lastRec(rest)
      case List()    => None
    }
  }

  // Find the last but one element of a list.
  object Problem02 {
    //def penultimate[T](list: List[T]) : Option[T] = Some(list.init last)  
    def penultimate[T](list: List[T]) : Option[T] = list match {
      case x :: y :: Nil  => Some(x)
      case x :: rest      => penultimate(rest)
      case List()         => None
    }
  }

  // Find the Kth element of a list.
  object Problem03 {
    def kth[T](k: Int, list: List[T]): Option[T] = list match {
      case List() => None
      case _ => k match {
        case k if (k > 1 && k < list.size) => Option(list take k + 1 last)
        case _ => None
      }
    }
  }
  // Reverse a list
  object Problem04 {
    def lengthUsual[T](list: List[T]): Int = list.length

    def lengthWithoutTailrec[T](list: List[T]): Int = list match {
      case List()     => 0
      case x :: rest  => 1 + length(rest) 
    }

    def length[T](list: List[T]): Int = {
      @tailrec def len(acc: Int, someList: List[T]) : Int = someList match {
        case List()     => acc
        case x :: rest  => len(acc + 1, rest) 
      }
      len(0, list)
    }
  }
  // Reverse a list
  object Problem05 {
    def reverseUsual[T](list: List[T]): List[T] = list.reverse
      
    def reverse[T](list: List[T]): List[T] = {
       @tailrec def rev[T](acc: List[T], original: List[T]): List[T] = original match {
         case List()     => acc 
         case x :: rest  => rev(List[T](x) ::: acc, rest)
       }
       rev(Nil, list) 
    }
  }
  // Find out whether a list is a palindrome
  object Problem06 {
      
    def isPalindromeNatural[T](list: List[T]): Boolean = list == list.reverse
      
    def isPalindrome[T](list: List[T]): Boolean = list match {
        case Nil       => true
        case x :: Nil  => true
        case x :: rest => (x == rest.last) match {
                            case true  => isPalindrome(rest dropRight 1)
                            case false => false
                        }
    }               
  }
  // Flatten a nested list structure
  object Problem07 {
    def flattenUsualWay(list: List[Any]) : List[Any] = list flatMap {
        case x: List[Any] => flattenUsualWay(x)
        case x: Any       => List(x)
    }

      def flatten(list: List[Any]) : List[Any] = {
        
        def flat(acc: List[Any], list: List[Any]) : List[Any] = list match {
              case Nil                   => acc
              case (x:List[Any]) :: rest => flat(acc ::: flat(List(), x) , rest)
              case (x:Any) :: rest       => flat(acc ::: List(x), rest)
        }
      
        flat(List(), list)
      }         
  }
  
  // Eliminate consecutive duplicates of list elements
  object Problem08 {
    def compress(list: List[Any]) : List[Any] = {
        def compress0(acc: List[Any], list: List[Any]) : List[Any] = list match {
            case Nil                   => acc
            case (x:Any) :: rest       => (acc.last == x) match {
                                            case true  => compress0(acc, rest)
                                            case false => compress0(acc ::: List(x), rest)
                                          }
        }
      
        list match {
          case Nil => list
          case _   => compress0(List(list.head), list.drop(1))
        }
    }
    
    def compress2(list: List[Any]) : List[Any] =  {
        @tailrec
        def comp2(acc: List[Any], startList: List[Any]) : List[Any] = startList match {
          case Nil       => acc
          case x :: rest => comp2(acc ::: List(x), rest.dropWhile( _ == x))
        }
        comp2(List(), list)
    } 

  }    

  // Pack consecutive duplicates of list elements into sublists
  object Problem09 {
      def pack(list: List[Any]) : List[Any] = {

      @tailrec
      def packR(acc: List[Any], ls: List[Any]) : List[Any] = ls match {
        case x :: rest => packR(ls.takeWhile (_ == x) :: acc, ls.dropWhile(_ == x))
        case List() => acc.reverse
      }
      
      def pack2R(acc: List[Any], ls: List[Any]) : List[Any] = ls match {
        case x :: tail	=>  val (same, rest) = ls.span(_ == x); packR(same :: acc, rest)
        case List()     => acc
      }
      
      pack2R(List(), list)
    }         
  }

}