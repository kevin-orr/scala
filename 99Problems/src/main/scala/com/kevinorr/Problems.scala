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
}