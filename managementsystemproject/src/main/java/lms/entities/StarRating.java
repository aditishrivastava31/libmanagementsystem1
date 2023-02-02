package lms.entities;

public enum StarRating {
	zero("0"), one("1"), two("2"), three("3"), four("4"), five("5");

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	private String rating;

	private StarRating(String rating) {
		this.rating = rating;
	}

}
