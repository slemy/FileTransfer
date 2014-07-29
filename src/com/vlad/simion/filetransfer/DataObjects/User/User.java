package com.vlad.simion.filetransfer.DataObjects.User;

import java.util.HashMap;

public class User {
	
	private static User m_Instance;
	
	private String m_Id;
	private String m_UserFirstName;
	private String m_UserLastName;
	private String m_Email;
	private String m_Phone;
	private HashMap<String, String> m_Details;
	private String m_EncodedImage;
	
	private User(){
	}
		
	public static synchronized User getUser (){
	
		if(m_Instance == null){
			m_Instance = new User();
		}
	
		return m_Instance;
	}
	
	public static void setUser(User _user){
		m_Instance = _user;
	}
	
	public void addDetail(String _tagName, String _tagValue){
		this.m_Details.put(_tagName, _tagValue);
	}

	public String get_Id() {
		return m_Id;
	}

	public void set_Id(String m_Id) {
		this.m_Id = m_Id;
	}

	public String get_UserFirstName() {
		return m_UserFirstName;
	}

	public void set_UserFirstName(String m_Username) {
		this.m_UserFirstName = m_Username;
	}
	
	public String get_UserLastName(){
		return m_UserLastName;
	}
	
	public void set_UserLastName(String _userLastName){
		this.m_UserLastName = _userLastName;
	}

	public String get_Email() {
		return m_Email;
	}

	public void set_Email(String m_Email) {
		this.m_Email = m_Email;
	}

	public String get_Phone() {
		return m_Phone;
	}

	public void set_Phone(String m_Phone) {
		this.m_Phone = m_Phone;
	}

	public HashMap<String, String> get_Details() {
		return m_Details;
	}

	public void set_Details(HashMap<String, String> m_Details) {
		this.m_Details = m_Details;
	}

	public String get_EncodedImage() {
		return m_EncodedImage;
	}

	public void set_EncodedImage(String m_EncodedImage) {
		this.m_EncodedImage = m_EncodedImage;
	}
}
