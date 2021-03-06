package se.tidsmaskinen.ksamsok;

import java.util.ArrayList;
import java.util.List;

import se.tidsmaskinen.utils.ImageUtils;
import android.graphics.Bitmap;

import com.google.android.maps.GeoPoint;

public class ListItem 
{

	
	private String mTitle = "-";
	private String mThumbnailURL;
	private Bitmap mThumbnail = null;
	private List<String> mImages = new ArrayList<String>();
	private String mDescription;
	private String mType;
	private String mIdLabel;
	private String mTimeLabel;
	private String mPlaceLabel;
	private String mOrganization;
	private String mLink;
	private String mXmlLink;
	private GeoPoint mCoordinates;

	
	public String getTitle() { return mTitle; }
	public void setTitle(String title){	this.mTitle = title.trim();}

	public String getThumbnailURL(){ return mThumbnailURL; }
	public void setThumbnailURL(String thumbnailURL)
	{ 
		this.mThumbnailURL = thumbnailURL.trim();
		setThumbnail(thumbnailURL.trim());
	}
	
	/** Gets and sets the items thumbnail. */
	public Bitmap getThumbnail(){ return mThumbnail; }
	public void setThumbnail(Bitmap thumbnail){ this.mThumbnail = thumbnail; }
	private void setThumbnail(String thumbnailURL)
	{ 
	
	      
	        Bitmap bitmap = ImageUtils.downloadImage(thumbnailURL);
			this.mThumbnail = bitmap; 
		
	}
	
	/** Gets and sets the items images. */
	public List<String> getImages(){ return mImages; }
	public void setImages(String image)
	{ 
		
		this.mImages.add(image);
	}

	/** Gets and sets the items description. */
	public String getDescription(){	return mDescription;	}
	public void setDescription(String description)
	{	
		if (this.mDescription != null){this.mDescription += "\n\n" +description.trim();}
		else{this.mDescription = description.trim();}		
	}
	
	/** Gets and sets the items type. */
	public String getType() { return mType; }
	public void setType(String type){	this.mType = type.trim();}
	
	/** Gets and sets the items id label. */
	public String getIdLabel() { return mIdLabel; }
	public void setIdLabel(String idLabel){	this.mIdLabel = idLabel.trim();}
	
	/** Gets and sets the items time label. */
	public String getTimeLabel() { return mTimeLabel; }
	public void setTimeLabel(String timeLabel){
		
		String[] dateStrings = timeLabel.split(" - ");
		if(dateStrings.length > 1) {
			//if(dateStrings[0].equals(dateStrings[1])) {
				timeLabel = dateStrings[0];
			//}
		}
		
		this.mTimeLabel = timeLabel.trim();
	}
	
	/** Gets and sets the items place label. */
	public String getPlaceLabel() { return mPlaceLabel; }
	public void setPlaceLabel(String placeLabel){	this.mPlaceLabel = placeLabel.trim();}
	
	/** Gets and sets the items organization. */
	public String getOrganization() { return mOrganization; }
	public void setOrganization(String organization){	this.mOrganization = organization.trim();}
	
	/** Gets and sets the source link. */
	public String getLink() { return mLink; }
	public void setLink(String link){	this.mLink = link.trim();}

	/** Gets and sets the items coordinates. */
	public GeoPoint getCoordinates() { return mCoordinates; }	
	public void setCoordinates(String coordinates)
	{	
		String[] coords = coordinates.split ("\\,");

		Double latitude = Double.parseDouble(coords[1]);
		Double longitude = Double.parseDouble(coords[0]);
		this.mCoordinates = new GeoPoint((int)(latitude*1e6), (int)(longitude*1e6));
	}
	public void setXmlLink(String nextText) {
		mXmlLink = nextText;
		
	}
	public String getXmlLink(){
		return mXmlLink;
	}
	
}
