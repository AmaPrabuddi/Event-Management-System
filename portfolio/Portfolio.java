package com.portfolio;

public class Portfolio {
	int id;
	String category;
	String name;
	String venue;
	String date;
	String introduction;
	String image1;
	String image2;
	String image3;
	
	

	public Portfolio(int id, String category, String name, String venue, String date, String introduction,
			String image1, String image2, String image3) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.venue = venue;
		this.date = date;
		this.introduction = introduction;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getVenue() {
		return venue;
	}



	public void setVenue(String venue) {
		this.venue = venue;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getIntroduction() {
		return introduction;
	}



	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}



	public String getImage1() {
		return image1;
	}



	public void setImage1(String image1) {
		this.image1 = image1;
	}



	public String getImage2() {
		return image2;
	}



	public void setImage2(String image2) {
		this.image2 = image2;
	}



	public String getImage3() {
		return image3;
	}



	public void setImage3(String image3) {
		this.image3 = image3;
	}

	

}
