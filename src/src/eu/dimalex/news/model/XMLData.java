package eu.dimalex.news.model;

import android.graphics.Bitmap;

public class XMLData {
	private String mEventId;
	private String mType;
	private String mTitle;
	private String mReview;
	private String mText;
	private Bitmap mImage;
	private String mUsersCount;
	
	public XMLData(String id, String type, String title, String review, String text, 
			Bitmap image, String count){
		this.mEventId = id;
		this.mType = type;
		this.mTitle = title;
		this.mReview = review;
		this.mText = text;
		this.mImage = image;
		this.mUsersCount = count;
	}

	/**
	 * @return the mEventId
	 */
	public String getEventId() {
		return mEventId;
	}

	/**
	 * @param mEventId the mEventId to set
	 */
	public void setEventId(String mEventId) {
		this.mEventId = mEventId;
	}

	/**
	 * @return the mType
	 */
	public String getType() {
		return mType;
	}

	/**
	 * @param mType the mType to set
	 */
	public void setType(String mType) {
		this.mType = mType;
	}

	/**
	 * @return the mTitle
	 */
	public String getTitle() {
		return mTitle;
	}

	/**
	 * @param mTitle the mTitle to set
	 */
	public void setTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	/**
	 * @return the mReview
	 */
	public String getReview() {
		return mReview;
	}

	/**
	 * @param mReview the mReview to set
	 */
	public void setReview(String mReview) {
		this.mReview = mReview;
	}

	/**
	 * @return the mText
	 */
	public String getText() {
		return mText;
	}

	/**
	 * @param mText the mText to set
	 */
	public void setText(String mText) {
		this.mText = mText;
	}

	/**
	 * @return the mImage
	 */
	public Bitmap getImage() {
		return mImage;
	}

	/**
	 * @param mImage the mImage to set
	 */
	public void setImage(Bitmap mImage) {
		this.mImage = mImage;
	}

	/**
	 * @return the mUsersCount
	 */
	public String getUsersCount() {
		return mUsersCount;
	}

	/**
	 * @param mUsersCount the mUsersCount to set
	 */
	public void setUsersCount(String mUsersCount) {
		this.mUsersCount = mUsersCount;
	}
}
