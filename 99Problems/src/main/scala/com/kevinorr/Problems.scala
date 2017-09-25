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
}