package block_chain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Base64;

/**
 * <code> Block </code> contains fields related to block/transaction data.
 * 
 * @author darshan.dalwadi
 *
 */
public class Block {

	private String version;
	private String hash;
	private String previousHash;
	private Timestamp timestamp;
	private String data;

	/**
	 * Constructor (hash and previousHash will be set programmatically)
	 * 
	 * @param version
	 * @param timestamp
	 * @param data
	 */
	public Block(String version, Timestamp timestamp, String data) {
		super();
		this.version = version;
		this.timestamp = timestamp;
		this.data = data;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	/**
	 * @return the previousHash
	 */
	public String getPreviousHash() {
		return previousHash;
	}

	/**
	 * @param previousHash the previousHash to set
	 */
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * <code> computeHash </code> is used to compute the hash of current
	 * transaction.
	 * 
	 * @return
	 */
	public String computeHash() {

		// Set value based on hash will be generated.
		String dataToHash = "" + this.version + this.timestamp + this.previousHash + this.data;

		MessageDigest digest;
		String encoded = null;

		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
			encoded = Base64.getEncoder().encodeToString(hash);
		} catch (NoSuchAlgorithmException exception) {
			exception.printStackTrace();
		}

		this.hash = encoded;
		return encoded;
	}

	@Override
	public String toString() {
		return "[version=" + version + ", hash=" + hash + ", previousHash=" + previousHash + ", timestamp="
				+ timestamp + ", data=" + data + "]";
	}
	
}
