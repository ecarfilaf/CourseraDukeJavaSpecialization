
/**
 * Write a description of LogEntry here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/17
 */
import java.util.*;

public class LogEntry {
	private String ipAddress;
	private Date accessTime;
	private String request;
	private int statusCode;
	private int bytesReturned;

	public LogEntry(String ip, Date time, String req, int status, int bytes) {
		ipAddress = ip;
		accessTime = time;
		request = req;
		statusCode = status;
		bytesReturned = bytes;

	}

	public String getIpAddress() {
		return ipAddress;
	}

	public Date getAccessTime() {
		return accessTime;
	}

	public String getRequest() {
		return request;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public int getBytesReturned() {
		return bytesReturned;
	}

	public String toString() {
		return ipAddress + " " + accessTime + " " + request
				+ " " + statusCode + " " + bytesReturned;
	}

}
