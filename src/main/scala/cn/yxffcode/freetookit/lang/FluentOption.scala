package cn.yxffcode.freetookit.lang

/**
  * @author gaohang on 16/8/8.
  */
class FluentOption[T](srcoption: Option[T] = None) {
    private val option: Option[T] = srcoption;

    def or(defaultValue: T): T = if (isPresent) get else defaultValue

    def isPresent: Boolean = !option.isEmpty

    def get: T = option.get

    /**
      * 将此Option传递,表示一次方法调用
      */
    def flow[A](function: Function1[T, A]): FluentOption[A] = {
        if (!isPresent) {
            return FluentOption.ABSENT.asInstanceOf[FluentOption[A]]
        }
        val result: A = function(get)
        if (result == null) {
            return FluentOption.ABSENT.asInstanceOf[FluentOption[A]]
        }
        return new FluentOption[A](Some(result))
    }
}

object FluentOption {
    private val ABSENT: FluentOption[AnyRef] = new FluentOption[AnyRef];

    def apply[T](obj: T): FluentOption[T] = {
        if (obj == null) {
            ABSENT.asInstanceOf[FluentOption[T]]
        } else {
            new FluentOption[T](Some(obj))
        }
    }
}
