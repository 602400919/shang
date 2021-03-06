package cn.wh.shang.common;

public class User {
	private int id;
	private String name;
    private Integer age;

    //序列化传输的时候必须要有空构造方法，不然会出错
    public User() {
    }
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
    
}