访问控制和继承

请注意以下方法继承的规则：

    父类中声明为 public 的方法在子类中也必须为 public。

    父类中声明为 protected 的方法在子类中要么声明为 protected，要么声明为 public，不能声明为 private。

    父类中声明为 private 的方法，不能够被继承。
