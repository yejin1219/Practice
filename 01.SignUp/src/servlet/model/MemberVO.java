package servlet.model;

public class MemberVO {

	
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String gender;
	
	
	public MemberVO() {
		
	}


	public MemberVO(String id, String password, String name, String nickname, String gender) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", nickname=" + nickname
				+ ", gender=" + gender + "]";
	}
	
	
	
	
}
