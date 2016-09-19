// IMyAidlInterface.aidl
package lee.vioson.aidldemo;

// Declare any non-default types here with import statements
import lee.vioson.aidldemo.Model;

interface IMyAidlInterface {
   List<Model> add(in Model model);
//      int add(int num1,int num2);
}
