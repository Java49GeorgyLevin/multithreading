package telran.multithreading.messaging;

import java.util.concurrent.TimeUnit;
import java.util.LinkedList;
import java.util.concurrent.locks.*;

public class MyLinkedBlockingQueue<E> implements MyBlockingQueue<E> {
	int limit;
	
	private LinkedList<E> queue = new LinkedList<>();
	private Lock monitor = new ReentrantLock();
	private Condition conditionForProducer = monitor.newCondition();
	private Condition conditionForConsumer = monitor.newCondition();
	

	public MyLinkedBlockingQueue(int limit) {
		super();
		this.limit = limit;
	}

	@Override
	public boolean add(E e) {
		try {
			monitor.lock();
			if(queue.size() == limit) {
				throw new IllegalStateException();
			}
			boolean res = queue.add(e);
			conditionForConsumer.signal();
			return res;
		} finally {
			monitor.unlock();
		}
	}

	@Override
	public boolean offer(E e) {
		boolean res = false;
		try {
			monitor.lock();
			if(queue.size() < limit) {
				res = queue.add(e);
				conditionForConsumer.signal();
			}	
			return res;
		} finally {
			monitor.unlock();
		}		
	}

	@Override
	public void put(E e) throws InterruptedException {
		try {
			monitor.lock();
			while(queue.size() == limit) {				
					conditionForProducer.await();
			}
			queue.add(e);
			conditionForConsumer.signal();			
		} finally {
			monitor.unlock();
		}		
	}

	@Override
	public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
		try {
			monitor.lock();
			while(queue.size() == limit) {	
				if(!conditionForProducer.await(timeout, unit)) {
					return false;
			} 
				}
				queue.add(e);
				conditionForConsumer.signal();
				return true;
					
		} finally {
			monitor.unlock();
		}
	}

	@Override
	public E take() throws InterruptedException {
		try {
			monitor.lock();
			while( queue.isEmpty()) {
				conditionForConsumer.await();
			}
			E res = queue.remove(0);
			conditionForProducer.signal();
			return res;
		} finally {
			monitor.unlock();
		}		
	}

	@Override
	public E poll(long timeout, TimeUnit unit) throws InterruptedException {
		try {
			monitor.lock();
			while(queue.isEmpty()) {
				if(!conditionForConsumer.await(timeout, unit)) {
					return null;
				}
			}
			E res = queue.remove();
			return res;
		} finally {
			monitor.unlock();
		}
		
	}

	@Override
	public E remove() {
		try { 
			monitor.lock();
			E res = queue.remove();
			conditionForProducer.signal();;
			return res;

		} finally {
			monitor.unlock();
		}		
	}

	@Override
	public E peek() {
		E res = null;
		try {
			monitor.lock();
			if(queue.size() != 0) {
				res = queue.get(0);
			}
			return res;
		} finally {
			monitor.unlock();
		}
	}

	@Override
	public E element() {
		try {
			monitor.lock();
			return queue.element();
		} finally {
			monitor.unlock();
		}		
	}

	@Override
	public E poll() {
		E res = null;
		try {
			monitor.lock();
			res = queue.poll();
			if(res != null) {
				conditionForProducer.signal();
			}
			return res;			
		} finally {
			monitor.unlock();
		}		
	}	

}
