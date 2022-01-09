package yun520.xyz.javastudy.多态;



///多态实现的原理，后期方法绑定：在运行时根据对象的类型进行绑定，后期绑定也叫做动态绑定或则运行时绑定。和所以成员变量（访问域），静态方法，私有方法不存在覆盖
public class PrivateOverride {
    int a=0;

    private void f(){
        System.out.println("private f()");
    }
    public void c()  {
        System.out.println("PrivateOverride");
    }
    public  static  void  main(String[] args){
        PrivateOverride derived = new Derived();
        //直接访问变量是访问的父类的，应为任何域访问都不多态的
        System.out.println(derived.a);
        derived.f();
        derived.c();
    }


}
 class Derived  extends PrivateOverride{
     int a=1;
    public void f()  {
        System.out.println("public f");
    }
     public void e()  {
         System.out.println("public e");
     }
     public void c()  {
         System.out.println("Derived");
     }
}
