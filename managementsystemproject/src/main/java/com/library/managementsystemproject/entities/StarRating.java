package com.library.managementsystemproject.entities;

public enum StarRating {
	zero("0"),
    first("1"),
    second("2"),
    third("3"),
    fourth("4"),
    fifth("5");
	
	 public String getRating() {
	        return rating;
	    }
	    public void setRating(String rating) {
	        this.rating = rating;
	    }
	    private String rating;
	    private StarRating(String rating){
	        this.rating=rating;
	    }

}
