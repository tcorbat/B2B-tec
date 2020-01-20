package ch.b2btec.bl.domain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

public class Credentials {
	private static final String HASH_ALGORITHM_NAME = "SHA-256";
	private final int SALT_SIZE = 20;
	private final byte[] salt = new byte[SALT_SIZE];
	private final String loginName;
	private byte[] passwordHash;

	public Credentials(String loginName, String password) {
		checkLoginName(loginName);
		this.loginName = loginName;
		checkPassword(password);
		new Random(System.currentTimeMillis()).nextBytes(salt);
		this.passwordHash = createPasswordHash(password);
	}


	public String getLoginName() {
		return loginName;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (verifyPassword(oldPassword)) {
			passwordHash = createPasswordHash(newPassword);
		}
	}

	public boolean verifyPassword(String password) {
		if (password == null) {
			return false;
		}
		return Arrays.equals(passwordHash, createPasswordHash(password));
	}

	private byte[] createPasswordHash(String password) {
		var passwordBytes = password.getBytes(StandardCharsets.UTF_8);
		var combinedBytes = Arrays.copyOf(passwordBytes, passwordBytes.length + salt.length);
		System.arraycopy(salt, 0, combinedBytes, passwordBytes.length, SALT_SIZE);
		return createHash(combinedBytes);
	}

	private static byte[] createHash(byte[] input) {
		try {
			var md = MessageDigest.getInstance(HASH_ALGORITHM_NAME);
			return md.digest(input);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	private static void checkLoginName(String loginName) {
		if (!isValidLogin(loginName)) {
			throw new IllegalArgumentException("Login name must not contain non-alphanumeric characters");
		}
	}

	public static boolean isValidLogin(String loginName) {
		return loginName != null && !loginName.isBlank() && loginName.chars().allMatch(Character::isLetterOrDigit);
	}

	private static void checkPassword(String password) {
		if (!isValidPassword(password)) {
			throw new IllegalArgumentException("Password must not be empty and cannot contain white space characters");
		}
	}

	public static boolean isValidPassword(String password) {
		return password != null && !password.isBlank() && password.chars().noneMatch(Character::isWhitespace);
	}
}
