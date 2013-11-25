package support;

import tree.BinarySearchTree;
import dictionary.FoodInfo;

public class Dictionary {
	public BinarySearchTree<FoodInfo> food;
	public Dictionary(){
		food = new BinarySearchTree<FoodInfo>();
		FoodInfo fi;
		ReadDictionary rd = new ReadDictionary();
		rd.readFoodData ("food.txt");		
		for(int i = 0; i < rd.flist.size();i++)
		{
			fi = new FoodInfo(rd.flist.get(i).getFoodName(),rd.flist.get(i).getDescription());
			food.add(fi);
		}
		food.reset("INORDER");
	}
	
}
