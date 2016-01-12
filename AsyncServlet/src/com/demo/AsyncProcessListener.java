package com.demo;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

public class AsyncProcessListener  implements AsyncListener{

	@Override
	public void onComplete(AsyncEvent arg0) throws IOException {
		System.out.println("AsynchListener: onComplete");
		arg0.getAsyncContext().getResponse().getWriter().write("Listener: Request completed..<br>");
	}
	
	

	@Override
	public void onError(AsyncEvent arg0) throws IOException {
		System.out.println("AsynchListener: onError");
		arg0.getAsyncContext().getResponse().getWriter().write("Listener : Error occurred..<br>");
	}

	@Override
	public void onStartAsync(AsyncEvent arg0) throws IOException {
		System.out.println("AsynchListener: onStartAsync");
		arg0.getAsyncContext().getResponse().getWriter().write("Listener : OnstartAsync<br>");
	}

	@Override
	public void onTimeout(AsyncEvent arg0) throws IOException {
		System.out.println("AsynchListener: onTimeout");
		arg0.getAsyncContext().getResponse().getWriter().write("Request time out.. :( <br>"+Thread.currentThread().getName());
	}

	
}
