/**
 * 
 */
package Dating.User.Bean;

import java.util.Date;

/**
 * 2017/11/21
 * 
 * @author HaiRBk
 *
 */
public class InfoUser {
	private String id_user;
	private String full_name;
	private String password;
	private String weight;
	private String height;
	private Date birthday;
	private String sex;
	private String mail;
	private String religion;
	private String job;
	private String status;
	private String introduction;
	private String residence;
	private boolean on_off;
	private String type;

	public InfoUser(String id_user, String full_name, String password) {
		this.id_user = id_user;
		this.full_name = full_name;
		this.password = password;
	}

	public InfoUser(String weight, String height, Date birthday, String sex, String mail, String religion, String job,
			String status, String introdution, String residence, boolean on_off, String type) {
		this.weight = weight;
		this.height = height;
		this.birthday = birthday;
		this.sex = sex;
		this.mail = mail;
		this.religion = religion;
		this.job = job;
		this.status = status;
		this.introduction = introdution;
		this.residence = residence;
		this.on_off = on_off;
		this.type = type;
	}

	/**
	 * @return the id_user
	 */
	public String getId_user() {
		return id_user;
	}

	/**
	 * @param id_user
	 *            the id_user to set
	 */
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	/**
	 * @return the full_name
	 */
	public String getFull_name() {
		return full_name;
	}

	/**
	 * @param full_name
	 *            the full_name to set
	 */
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @param religion
	 *            the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the introduction
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * @param introduction
	 *            the introduction to set
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * @return the residence
	 */
	public String getResidence() {
		return residence;
	}

	/**
	 * @param residence
	 *            the residence to set
	 */
	public void setResidence(String residence) {
		this.residence = residence;
	}

	/**
	 * @return the on_off
	 */
	public boolean isOn_off() {
		return on_off;
	}

	/**
	 * @param on_off
	 *            the on_off to set
	 */
	public void setOn_off(boolean on_off) {
		this.on_off = on_off;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
