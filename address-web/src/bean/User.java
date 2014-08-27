package bean;

public class User {
	private String _id;
	private String _name;

	public User(){
	}

	public User(String id, String name){
		_id = id;
		_name = name;
	}

	public void setId(String id) {
		_id = id;
	}
	public void setName(String name) {
		_name = name;
	}
	public String getId() {
		return _id;
	}
	public String getName() {
		return _name;
	}
}
