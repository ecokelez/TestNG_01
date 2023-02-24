package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {

    @Override
    public void onStart(ITestContext arg){
        System.out.println("onStart - Tum testlerden once bir defa cagirilir => "+ arg.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish - Tum testlerden sonra bir defa cagrilir =>"+ context.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {
        //Before method'a benzer
        System.out.println("onTestStart - Method sayisi kadar,herbir  @Test annotioan'dan once bir defa calisir =>"+ result.getName());
        try {
            ReusableMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess - Pass olan method sayisi kadar ve Pass edilen methodlardan sonra bir defa calisir =>"+ result.getName());
        //ITestListener.super.onTestSuccess(result);
        try {
            ReusableMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped - Skippped edilen Method sayisi kadar ve skipped edilen methodlardan sonra bir defa calisir =>"+ result.getName());
        //ITestListener.super.onTestSkipped(result);

        try {
            ReusableMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure - Failed edilen Method sayisi kadar ve failed edien methodlardan sonra bir kez calisir=>"+ result.getName());

        try {
            ReusableMethods.getScreenshot(result.getName());
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}

