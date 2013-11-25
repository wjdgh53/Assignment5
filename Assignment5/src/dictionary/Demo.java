package dictionary;



import java.util.Scanner;

import support.ReadDictionary;
import tree.BinarySearchTree;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		String name;
		String description;
		BinarySearchTree<FoodInfo> food = new BinarySearchTree<FoodInfo>();
		FoodInfo fi;
		ReadDictionary rd = new ReadDictionary();
		rd.readFoodData ("food.txt");
		
		for(int i = 0; i < rd.flist.size();i++)
		{
			fi = new FoodInfo(rd.flist.get(i).getFoodName(),rd.flist.get(i).getDescription());
			food.add(fi);
		}
		
		System.out.println(food.size());
		food.reset("INORDER");
		for(int i = 0; i <food.size();i++)
		{
			System.out.println(food.getNext("INORDER"));
		}
		System.out.println("Please enter the food name you want to find");
		name = keyboard.nextLine();
		fi = new FoodInfo(name);
		System.out.println(fi);
		System.out.println(food.get(fi));
		System.out.println(food.contains(fi));
		System.out.println(food.contains(food.get(fi)));
		/*if(food.contains(fi))
		{
			System.out.println(food.get(fi));
		}else{
			System.out.println("Our Dictionary does not have that item please enter the description");
			description = keyboard.nextLine();
			FoodInfo fi2 = new FoodInfo(name,description);
			food.add(fi2);			
			rd.flist.add(fi2);
		}
		System.out.println(food.size());
		food.reset("INORDER");
		rd.writeBackToFile("result.txt");*/
	}

}
