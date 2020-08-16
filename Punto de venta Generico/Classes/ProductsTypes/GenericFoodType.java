package ProductsTypes;
import java.util.*;



//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class GenericFoodType  implements java.io.Serializable{
	enum SuperCat{Frezer,Dry,Cocked,Cooling,Generic}
	enum LittleCatSolid{Meat,Dairy,Snack,Fried,Other}
	public boolean Solid;
	public enum LittleCatLiquid{Water,Milk,Sauce,Alcohol,Juice,EnergyD,Other}
	public String Nombre,Description,ID;
	public int Quantity,LastSell,PriceF, PriceIVA,PriceBase,AverageIncome,BuyCost,flag;
	public ArrayList<String> BarCodes;	
	public SuperCat MasterCategory;
	public LittleCatSolid SubCategory1;
	public LittleCatLiquid SubCategory2;
	public GenericFoodType
	(int MCat,int SCat,int quantity,int lastsell,int price,	int iva,
	 int buycost ,String name ,String desc,boolean x)
	{ Solid=x;
		switch(MCat) {
		case 0:MasterCategory=SuperCat.Frezer;break;
		case 1:MasterCategory=SuperCat.Dry;break;
		case 2:MasterCategory=SuperCat.Cocked;break;
		case 3:MasterCategory=SuperCat.Cooling;break;
		default:MasterCategory=SuperCat.Generic;break;}
		if(Solid) {switch(SCat) {
	   case 0: SubCategory1=LittleCatSolid.Meat;break;
	   case 1: SubCategory1=LittleCatSolid.Dairy;break;
	   case 2: SubCategory1=LittleCatSolid.Snack;break;
	   case 3: SubCategory1=LittleCatSolid.Fried;break;
	   default: SubCategory1=LittleCatSolid.Other;break;}
		SubCategory2=LittleCatLiquid.Other;}
		else { SubCategory1=LittleCatSolid.Other;switch(SCat){
			case 0:SubCategory2=LittleCatLiquid.Water; break;
			case 1:SubCategory2=LittleCatLiquid.Milk; break;
			case 2:SubCategory2=LittleCatLiquid.Sauce; break;
			case 3:SubCategory2=LittleCatLiquid.Alcohol; break;
			case 4:SubCategory2=LittleCatLiquid.Juice; break;
			case 5:SubCategory2=LittleCatLiquid.EnergyD; break;
			default:SubCategory2=LittleCatLiquid.Other; break;}}
		Quantity=quantity; LastSell=lastsell;
		PriceIVA=(price/100)*iva;PriceBase=price;PriceF=price+((price/100)*iva);			
		BuyCost=buycost;
		AverageIncome=(PriceBase-BuyCost);
		
		if(name==null||name.length()<3) {Nombre="Generic Product";}
		else {Nombre=name;}
		
		if(desc==null||desc.length()<3) {Description="No Description";}
		else {Description=desc;}
	
		
	}	
	public GenericFoodType()
	{
		Solid=true;
	MasterCategory=SuperCat.Generic;
		 SubCategory1=LittleCatSolid.Other;
		SubCategory2=LittleCatLiquid.Other;
		Quantity=0; 
		LastSell=0;
		PriceIVA=0;
		PriceBase=0;
		PriceF=0;			
		BuyCost=0;
		AverageIncome=(PriceBase-BuyCost);
		Nombre="Generic Product";		
		Description="A Generic Product, Named";
	}
	
		
	//public static void main(String[] args) { 	}
	public void AddBarCode(String NewCOde) {
	
	BarCodes.add(NewCOde);
	   LinkedHashSet<String> newlist = new LinkedHashSet<String>();
	   newlist.addAll(BarCodes);
	   BarCodes.clear();
	   BarCodes.addAll(newlist);
	   Collections.sort(BarCodes);
	   }		
	public String DeleteBarCode(String Code) {
	if(BarCodes.contains(Code)) {
		BarCodes.remove(Code);
		if(BarCodes.size()<1) {return "Barcodes List is Empty";}
		return "Barcode Removed";
	}
	return "Barcode not found";
   }
	
}