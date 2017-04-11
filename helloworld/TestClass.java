package helloworld;

/**
 * Created by 1234 on 3/20/2017.
 */
public class TestClass {


    int initialData;


    public TestClass(int initialData) {
        this.initialData = initialData;

        initialData =initialData*5;
    }


    public int getInitialData() {

       initialData=initialData+1;
        System.out.println("Message from the method:" + initialData);
        return initialData;
    }
}
