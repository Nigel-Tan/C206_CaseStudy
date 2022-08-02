
public class Category {
	private String name;
	
	public Category(String name) {
		this.name = name;
	}

	public String getCategory() {
		return name;
	}
	
	public String display() {
		String output = String.format("%-20s",name);
		return output;
	}

}

