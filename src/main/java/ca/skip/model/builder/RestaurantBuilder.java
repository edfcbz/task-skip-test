package ca.skip.model.builder;

import ca.skip.models.Restaurant;

public class RestaurantBuilder {
	public static Restaurant restaurant;
	
	public RestaurantBuilder() {
		restaurant = new Restaurant();
		withName("Restaurant name");
		withEmail("restaurant@gmail.com");
	}
	
	public  RestaurantBuilder withName(String name) {
		restaurant.setName(name);
		return this;
	}
	
	public RestaurantBuilder withEmail(String email) {
		restaurant.setEmail(email);
		return this;
	}

	public Restaurant now() {
		return restaurant;
	}

}
