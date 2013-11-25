package dictionary;

public class FoodInfo implements Comparable<FoodInfo> {

	String foodName;
	String description;
	
	public FoodInfo(String foodName, String description) {
		super();
		this.foodName = foodName;
		this.description = description;
	}
	public FoodInfo(String foodName)
	{
		super();
		this.foodName = foodName;
		this.description = null;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "FoodInfo [foodName=" + foodName + ", description="
				+ description + "]";
	}

	@Override
	public int compareTo(FoodInfo other) {
		
		/*if (this.getFoodName().compareTo(other.getFoodName()) == 0)
		      return 0;
		else if (this.getFoodName().compareTo(other.getFoodName()) == 0)
		        return 0;
		      else 
		        return +1;*/
		return this.getFoodName().compareTo(other.getFoodName());
	}
	
	
}
