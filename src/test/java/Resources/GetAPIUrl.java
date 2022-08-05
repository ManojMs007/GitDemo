package Resources;

public enum GetAPIUrl {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	DeletePlaceAPI("/maps/api/place/delete/json"),
	GetPlaceAPI("/maps/api/place/get/json");
	
	private String Resource;
	 GetAPIUrl(String Resource)
	{
		this.Resource = Resource;
		
	}
	 public String GetResource()
	 {
		 return Resource;
	 }
	

}
