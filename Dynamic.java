import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JFormattedTextField.AbstractFormatter;


public class Solution {
	ArrayList<Gadget> gadgets;
	int[][] data;
	int[][] memos;
	int size;
	int weightLimit;
	
public Solution(int[][] data, int weightLimit){
	this.data=data;
	this.gadgets = new ArrayList<>();
	this.size=data[0].length;
	this.memos= new int[size][weightLimit];
	this.weightLimit=weightLimit;
	//initialize memos
	for(int i=0;i<this.size;i++){
		for(int j=0;j<this.weightLimit;j++)
		memos[i][j]=-1;
	}
	
}
	
	
	public class  Gadget {
		int weight;
		int value;
		
	public Gadget(int weight, int value){
		this.value = value;
		this.weight = weight;
	
	}
		
	}
	
	/*
	 * initialize the gadget, read data from
	 * 2d array and add them into gadget 
	 * 
	 */
	
	public void initialize(){
		for(int i=0;i<this.data[0].length;i++){
			int value= data[0][i];
			int weight= data[1][i];
			Gadget gadget = new Gadget(weight, value);
			this.gadgets.add(gadget);
			}
	
		
	}
	
	

	
	public int knapsack(int item, int limit ){
		
	if(item==-1){
		return 0;
	}
	else if(gadgets.get(item).weight>limit){
		return knapsack(item-1, limit);
	}
	
	else if(memos[item][limit]==-1){
	memos[item][limit] = Math.max(knapsack(item-1, limit) , 
				gadgets.get(item).value+knapsack(item-1, limit - gadgets.get(item).weight));
	
	}	
	return memos[item][limit];	


	
	}
	
	
	public void printGadget(){
		for(Gadget g:gadgets){
			System.out.println(g.value + " ,"+g.weight);
		}
	}
	
	
	
	
	
	
	public static void main (String[] args) {
		/*
		  ArrayList<String> square = new ArrayList<>();
			String string;
			Scanner scanner = new Scanner(System.in);
			
			while(scanner.hasNext()){
				string= scanner.nextLine();
				square.add(string);
				}
			int size =  Integer.parseInt(square.get(0));
	        int weightLimit = Integer.parseInt(square.get(3));
			int[][] data = new int[2][size];
	        
	        String temp ="";
	        int count=0;
			for(int i =1; i<3;i++){
				for(int j=0;j<square.get(i).length(); j++){
					if(square.get(i).charAt(j)==','){
	                    data[i-1][count]= Integer.parseInt(temp);
	                     temp="";
	                    count++;
					}
					else {
				temp+= square.get(i).charAt(j);		
					}
				}
	            data[i-1][count]=Integer.parseInt(temp);
	            temp="";
	            count=0;
	            
	            
			}
			
		*/
		
		
		
		
		//20,21,22,24,26,27,30,31,34,36,    37,38,39,41,43,44,45,46,47,48,   49,50,52,53,54,55,56,58,59,60
		
		
		
		int[][] data = new int[2][30];
		
		// 0 is value
		data[0][0]=20;
		data[0][1]=21;
		data[0][2]=22;
		data[0][3]=24;
		data[0][4]=26;
		data[0][5]=27;
		data[0][6]=30;
		data[0][7]=31;
		data[0][8]=34;
		data[0][9]=36;
		
		data[0][10]=37;
		data[0][11]=38;
		data[0][12]=39;
		data[0][13]=41;
		data[0][14]=43;
		data[0][15]=44;
		data[0][16]=45;
		data[0][17]=46;
		data[0][18]=47;
		data[0][19]=48;
		
		data[0][20]=49;
		data[0][21]=50;
		data[0][22]=52;
		data[0][23]=53;
		data[0][24]=54;
		data[0][25]=55;
		data[0][26]=56;
		data[0][27]=58;
		data[0][28]=59;
		data[0][29]=60;
		
		// 1 is weight 
		
		//52,51,77,56,69,41,45,76,44,49,    71,47,78,66,58,43,79,59,80,63,   57,64,46,62,70,72,68,67,65,40
		data[1][0]=52;
		data[1][1]=51;
		data[1][2]=77;
		data[1][3]=56;
		data[1][4]=69;
		data[1][5]=41;
		data[1][6]=45;
		data[1][7]=76;
		data[1][8]=44;
		data[1][9]=49;
		
		data[1][10]=71;
		data[1][11]=47;
		data[1][12]=78;
		data[1][13]=66;
		data[1][14]=58;
		data[1][15]=43;
		data[1][16]=79;
		data[1][17]=59;
		data[1][18]=80;
		data[1][19]=63;
		
		data[1][20]=57;
		data[1][21]=64;
		data[1][22]=46;
		data[1][23]=62;
		data[1][24]=70;
		data[1][25]=72;
		data[1][26]=68;
		data[1][27]=67;
		data[1][28]=65;
		data[1][29]=40;
	
		
		Solution solution = new Solution(data,840);
		solution.initialize();
		//solution.printGadget();
		
		
		int result = solution.knapsack(29, 839);
		System.out.println(result);
		
		}
	

	

}
