package mianshi;

// 创建对象，分别打印A B C
// 我们通过flag来控制执行哪个方法
  class ThirdObject{
	
	private volatile int flag = 1;
	
	public synchronized void printA(){
		for (int i = 0; i < 5; i++) {
			
			// 如果不为1 ，说明还没有轮到当前线程执行方法，则进入wait方法，释放对象锁
			while(flag != 1){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.print("A ");
			
			// 下一个应该printB方法来执行
			flag = 2;
			this.notifyAll();
		}
	}
	
	public synchronized void printB(){
		for (int i = 0; i < 5; i++) {
			
			// 如果不为2 ，说明还没有轮到当前线程执行方法，则进入wait方法，释放对象锁
			while(flag != 2){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.print("B ");
			
			// 下一个应该printC方法来执行
			flag = 3;
			this.notifyAll();
		}
	}
	
	public synchronized void printC(){
		for (int i = 0; i < 5; i++) {
			
			// 如果不为3 ，说明还没有轮到当前线程执行方法，则进入wait方法，释放对象锁
			while(flag != 3){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.print("C ");
			
			// 下一个应该printA方法来执行
			flag = 1;
			this.notifyAll();
		}
	}
}
 
// 执行main方法
public class Test {
 
	public static void main(String[] args) {
		
		
		// 3.编写一个程序，启动三个线程，三个线程的ID分别是A，B，C；，每个线程将自己的ID值在屏幕上打印5遍，打印顺序是ABCABC...
		ThirdObject to = new ThirdObject();
		new Thread(new Runnable() {
					
			@Override
			public void run() {
				to.printA();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				to.printB();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				to.printC();
			}
		}).start();
    }
}