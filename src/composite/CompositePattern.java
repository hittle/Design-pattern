package composite;

import java.util.ArrayList;

/**
 * 项目描述：CompositePattern.java
 * @author lzl
 *
 * @date 2021年3月16日下午8:16:32
 * @version: V1.0
 */
public class CompositePattern {

	public static void main(String[] args) {
		Component c0 = new Composite();
		Component c1 = new Composite();
		Component leaf1 = new Leaf("1");
		Component leaf2 = new Leaf("2");
		Component leaf3 = new Leaf("3");
		c0.add(leaf1);
		c0.add(c1);
		c1.add(leaf2);
		c1.add(leaf3);
		c0.operation();
	}
}

//抽象构件
interface Component{
	public void add(Component c);
	public void remove(Component c);
	public Component getChild(int i);
	
	public void operation();
}

//树叶构件
class Leaf implements Component{

	String name;
	
	
	public Leaf(String name) {
		this.name = name;
	}

	@Override
	public void add(Component c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Component c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Component getChild(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void operation() {
		// TODO Auto-generated method stub
		System.out.println("树叶" + name + "：被访问！");
	}
	
}
//树枝构件
class Composite implements Component{

	private ArrayList<Component> children = new ArrayList<Component>();
	@Override
	public void add(Component c) {
		// TODO Auto-generated method stub
		children.add(c);
	}

	@Override
	public void remove(Component c) {
		// TODO Auto-generated method stub
		children.remove(c);
	}

	@Override
	public Component getChild(int i) {
		// TODO Auto-generated method stub
		return children.get(i);
	}

	@Override
	public void operation() {
		// TODO Auto-generated method stub
//		System.out.println("树枝：被访问！");
		for(Object obj : children) {
			((Component)obj).operation();
		}
	}
	
}