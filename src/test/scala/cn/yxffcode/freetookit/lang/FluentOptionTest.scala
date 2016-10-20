package cn.yxffcode.freetookit.lang

import cn.yxffcode.freetookit.collection.SingleValueList
import cn.yxffcode.freetookit.lang.Lang._

/**
  * @author gaohang on 16/8/14.
  */
object FluentOptionTest {

    def main(args: Array[String]): Unit = {
        val list = new SingleValueList[String](10, "abc")
        val option = FluentOption(list);
        option.flow(list => list(1)).flow(s => s.toUpperCase)
    }

    def test(id: Id) = println(id)

    lazy val list = List(1, 2, 3)
    lazy val strs: List[String] = list.map(i => i.toString);
}

object World {
    def apply(name: String): Country = if (name <-> "cn") new Country else null
}

class Country {
    def apply(name: String): City = if (name <-> "bj") new City else null
}

class City {
}
