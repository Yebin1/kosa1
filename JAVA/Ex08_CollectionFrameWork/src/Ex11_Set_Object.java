import java.util.HashSet;
import java.util.Iterator;

// 0913


class Myclass {
	private int id;
	private String name;
	
	public Myclass() {		
	}

	public Myclass(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Myclass [�й�=" + id + ", �̸�=" + name + "]";
	}
}


public class Ex11_Set_Object {

	public static void main(String[] args) {
		
		HashSet<Myclass> hset = new HashSet<Myclass>();
		
		Myclass mc1 = new Myclass(1, "Abc");
		Myclass mc2 = new Myclass(2, "Def");
		Myclass mc3 = new Myclass(3, "Asdf");

		Myclass mc4 = new Myclass(1, "Abc");
		
		hset.add(mc1);
		hset.add(mc4);
		hset.add(mc2);
		hset.add(mc3);
		System.out.println(hset.toString());
		
		System.out.println("-----------------------------------");
		
		for (Myclass m: hset) {
			System.out.println(m.toString());
		}
		
		System.out.println("-----------------------------------");
		
		Iterator<Myclass> itr = hset.iterator();
		while (itr.hasNext()) {
			Myclass mc = itr.next();
			System.out.println(mc.getId() + " / " + mc.getName());
		}
		
		System.out.println("-----------------------------------");
		
	}

}
