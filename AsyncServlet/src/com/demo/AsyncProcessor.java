package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;

public class AsyncProcessor  implements Runnable{

	private AsyncContext asyncContext;
	private PrintWriter printWriter;
	
	public AsyncProcessor(AsyncContext  asyncContext) {
		this.asyncContext=asyncContext;

		try {
			this.printWriter=asyncContext.getResponse().getWriter();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
	
		System.out.println("Async supported... ?? "+asyncContext.getRequest().isAsyncSupported());
		
		
		System.out.println("Execting task....");
		
		
		try {
			int i=1;
			while(i<=100){
				printWriter.write("<script>document.getElementById('progress').value='"+ i++ +"'</script>");
				printWriter.flush();
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		catch (Exception e) {
               e.printStackTrace();
		}
		
		System.out.println("inside runnable completed..");
		
		try {
			System.out.println("Original Request response ?:  "+asyncContext.hasOriginalRequestAndResponse());
			asyncContext.getResponse().getWriter().write("Async completed...<br>"+Thread.currentThread().getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//asyncContext.dispatch("/welcome.jsp");
		//asyncContext.dispatch();
		
		//asyncContext.complete();
	}
}
