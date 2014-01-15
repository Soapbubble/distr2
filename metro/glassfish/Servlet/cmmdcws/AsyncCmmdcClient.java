package cmmdc.client;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.xml.ws.BindingProvider;
import com.sun.xml.ws.developer.JAXWSProperties;
public class AsyncCmmdcClient {
    private CmmdcWS port;

    public AsyncCmmdcClient() {
        port = new CmmdcWSService().getCmmdcWSPort();
    }

    public static void main(String[] args) {
        try {
            AsyncCmmdcClient client = new AsyncCmmdcClient();
            //invoke synchronous method
            //client.invokeSynchronous();

            //invoke async polling method
            client.invokeAsyncPoll();

            //invoke async callback method
            client.invokeAsyncCallback();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
/*
    private void invokeSynchronous() throws RemoteException {
        int number1 = 10;
        int number2 = 20;

        System.out.println("\nInvoking synchronous addNumber():");
        int result = port.addNumbers(number1, number2);
        System.out.printf("The result of adding %d and %d is %d.\n", number1, number2, result);
    }
*/
    private void invokeAsyncPoll() throws InterruptedException, ExecutionException {
        int number1 = 10;
        int number2 = 20;

        //set request timeout to 30 sec, so that the client does n't wait forever
        int timeout = 30000;
        ((BindingProvider)port).getRequestContext().put(JAXWSProperties.REQUEST_TIMEOUT, timeout);

        System.out.println("\nInvoking Asynchronous Polling addNumbersAsync():");
        Response<CmmdcResponse> resp = port.cmmdcAsync(number1, number2);
        
        while (!resp.isDone()) {
            System.out.println("No Response yet, Sleeping for 1 sec");
            Thread.sleep(1000);
        }
        CmmdcResponse output = resp.get();
        System.out.printf("The result of adding %d and %d is %d.\n", number1, number2, output.getReturn());
    }

    private void invokeAsyncCallback() throws InterruptedException {
        long number1 = 10;
        long number2 = 20;

        System.out.println("\nInvoking Asynchronous Callback addNumbersAsync():");
        CmmdcCallbackHandler callbackHandler = new CmmdcCallbackHandler();
        Future<?> response = port.cmmdcAsync(number1, number2, callbackHandler);
        
        Thread.sleep(8000);
        if(response.isDone()) {
            CmmdcResponse output = callbackHandler.getResponse();
            System.out.printf("The result of adding %d and %d is %d.\n", number1, number2, output.getReturn());
        } else {
            System.out.println("Waited 8 sec, no response yet, something wrong");
        }        
    }

    /**
     * Async callback handler
     */
    private class CmmdcCallbackHandler implements AsyncHandler<CmmdcResponse> {
        private CmmdcResponse output;

        /*
        * @see javax.xml.ws.AsyncHandler#handleResponse(javax.xml.ws.Response)
        */
        public void handleResponse(Response<CmmdcResponse> response) {
            System.out.println("AddNumbersCallbackHandler: Received Response from the service");
            try {
                output = response.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        CmmdcResponse getResponse() {
            return output;
        }
    }

}
