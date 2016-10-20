package cn.yxffcode.freetookit.collection

import scala.collection.AbstractSeq

/**
  * @author gaohang on 16/8/14.
  */
class SingleValueList[A](len: Int, value: A) extends AbstractSeq[A] {
    override def length: Int = len

    override def apply(idx: Int): A = value

    override def iterator: Iterator[A] = new Iterator[A] {
        var idx: Int = 0

        override def hasNext: Boolean = idx < length

        override def next(): A = {
            idx = idx + 1
            value
        }
    }

}
