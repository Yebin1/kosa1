package DI_04_Spring;

public class MessageBeanImpl implements MessageBean {

	private String name;
	private String greeting;
	
	// 생성자 (Overloading Constructor) (Constructor Function)
	public MessageBeanImpl(String name) {
		this.name = name;
	}
	
	// Setter Function
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	@Override
	public void sayHello() {
		System.out.println(this.name + " / " + this.greeting);
	}
}
