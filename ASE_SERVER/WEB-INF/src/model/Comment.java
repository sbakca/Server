package model;

public class Comment {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private int comentId;

	public int getComentId() {
		return comentId;
	}

	public void setComentId(int comentId) {
		this.comentId = comentId;
	}

	private int nlike;

	public int getNlike() {
		return nlike;
	}

	public void setNlike(int nlike) {
		this.nlike = nlike;
	}

	private int dislike;

	public int getDislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

}
