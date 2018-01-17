package edu.knoldus

import org.apache.log4j.Logger

object Application extends App {

  val log = Logger.getLogger(this.getClass)
  val app = new ListOperations

  val element1 = 3
  val element2 = 4
  val element3 = 1
  val element4 = 2
  val inputList1 = List(element1, element2, element3, element4)
  val element5 = -2
  val element6 = 0
  val element7 = 12
  val inputList2 = List(element5, element6, element7)
  val subListElement1 = 4
  val subListElement2 = 1
  val subList1 = List(subListElement1, subListElement2)
  //val subList2 = List(3,2)

  log.info(s"Length of list = ${app.length(inputList1)}\n")
  log.info(s"After concatenation list = ${app.concatenateList(inputList1, inputList2)}\n")
  log.info(s"${app.hasSubSequence(inputList1, subList1)}\n")
  log.info(s"List is split into = ${app.splitList(inputList1, (elem: Int) => elem > 2)}")

}
