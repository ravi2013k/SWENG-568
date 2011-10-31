package edu.psu.sweng568.lesson2;

/**
 * This is a simple data object, one which we might want to share over a socket.  It contains the data that exists
 * on t
 * @author John
 *
 */
public class Student {
	
	private int studentID = 12345;
	private String name = "Bob Smith";
	private String socialSecurityNumber = "222-33-1111";
	private String emailAddress = "bsmith@yahoo.com";
	private String homePhone = "215-777-8888";
	private String homeAddress = "123 Tulip Road, Ambler, PA 19002";
	private String localAddress = "321 Maple Avenue, Lion Town, PA 16800";
	private String emergencyContact = "John Smith (215-222-6666)";
	private int programID = 206;
	private String paymentID = "111-206";
	private int academicStatus = 1;
	
	public int getStudentID() {
		return studentID;
	}
	public String getName() {
		return name;
	}
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public String getLocalAddress() {
		return localAddress;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public int getProgramID() {
		return programID;
	}
	public String getPaymentID() {
		return paymentID;
	}
	public int getAcademicStatus() {
		return academicStatus;
	}


}
