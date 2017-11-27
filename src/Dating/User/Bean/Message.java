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
public class Message {
	private String id_mess;
	private String content;
	private Date date;
	private String status;

	/**
	 * @return the id_mess
	 */
	public String getId_mess() {
		return id_mess;
	}

	/**
	 * @param id_mess
	 *            the id_mess to set
	 */
	public void setId_mess(String id_mess) {
		this.id_mess = id_mess;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
}
