package cn.yxffcode.freetookit.lang

import java.math.BigDecimal
import java.util.Objects

import com.google.common.base.Optional

/**
  * @author gaohang on 16/8/14.
  */
object Lang {
    
    implicit final class Equal[A](private val self: A) extends AnyVal {
        @inline def <->(ref: AnyRef) = Objects.equals(self, ref)
        
        @inline def !<->(ref: AnyRef) = !Objects.equals(self, ref)
    }

    implicit final class Add(private val self: BigDecimal) extends AnyVal {
        @inline def +(ref: BigDecimal) = self.add(ref);

        @inline def +(ref: Double) = self.add(new BigDecimal(ref));

        @inline def -(ref: Double) = self.subtract(new BigDecimal(ref));

        @inline def -(ref: BigDecimal) = self.subtract(ref);
    }

    implicit final class OptionTransform[T](private val self: Optional[T]) extends AnyVal {
        @inline def option: Option[T] = if (self.isPresent) Some(self.get()) else None
    }

    def apply(name: String) = println("hello " + name)

}
