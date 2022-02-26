import java.util.ArrayList;

public abstract class Buildable<T> {
	
	private ArrayList<T> components;
	
	public Buildable() {
		this.components = new ArrayList<T>();
	}
	
	public ArrayList<T> getComponents() {
		return this.components;
	}
	
	public void addComponent(T t) throws InvalidComponentConfigurationException {
		this.components.add(t);
	}
}
