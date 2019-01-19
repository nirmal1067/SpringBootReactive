package org.myexample.reactive.service;

import org.springframework.stereotype.Service;

import reactor.core.publisher.FluxSink;


@Service
public class CounterService {
	
	
	
	public void count(FluxSink<Integer> fluxSink,Integer count)
	{

		
		Thread t = new Thread(()-> {
			int tempCount=0;
			while(count>tempCount)
			{
				fluxSink.next(tempCount++);
				System.out.println(tempCount);
				//tempCount = 
				 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			fluxSink.complete();
			
		});
		
		t.start();
	}

}
