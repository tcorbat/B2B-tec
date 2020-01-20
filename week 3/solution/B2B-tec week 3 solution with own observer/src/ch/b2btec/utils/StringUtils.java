package ch.b2btec.utils;

public final class StringUtils {
	public static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}

	public static boolean containsOnlyDigits(String value) {
		return !isNullOrEmpty(value) && value.chars().allMatch(Character::isDigit);
	}
}
