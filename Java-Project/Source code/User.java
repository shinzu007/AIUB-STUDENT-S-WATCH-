/*User class 
 * setters and getters to set 
 * data and get data
 */
package demo1;

class User {

		private String firstName;
		private String lastName;
		private String fullName;
		private String userId;
		private String password;
		private String email;
		private String contactNo;
		private String status;
		private String dateOfBirth;
		private String gender;
		private String bloodGroup;
		private String department;
		
		public User(){
			
		}
		
		public void setF(String firstName){
			this.firstName=firstName;
		}
		public void setFf(String fullName){
			this.fullName=fullName;
		}
		public void setL(String lastName){
			this.lastName=lastName;
		}
		public void setU(String userId){
			this.userId=userId;
		}
		public void setP(String password){
			this.password=password;
		}
		public void setE(String email){
			this.email=email;
		}
		public void setG(String gender){
			this.gender=gender;
		}
		public void setC(String contactNo){
			this.contactNo=contactNo;
		}
		public void setS(String status){
			this.status=status;
		}
		public void setD(String y,String m,String d){
			this.dateOfBirth= y+"-"+m+"-"+d;
		}
		public void setD(String dateOfBirth){
			this.dateOfBirth=dateOfBirth;
		}
		
		public void setB(String bloodGroup){
			this.bloodGroup=bloodGroup;
		}
		public void setDp(String department){
			this.department=department;
		}
		
		public String getG(){
			return this.gender;
		}
		public String getF(){
			return this.firstName;
		}
		public String getFf(){
			return this.fullName;
		}
		public String getL(){
			return this.lastName;
		}
		public String getU(){
			return this.userId;
		}
		public String getP(){
			return this.password;
		}
		public String getE(){
			return this.email;
		}
		public String getC(){
			return this.contactNo;
		}
		public String getS(){
			return this.status;
		}
		public String getD(){
			return this.dateOfBirth;
		}

		public String getB(){
			return this.bloodGroup;
		}
		public String getDp(){
			return this.department;
		}
	}


