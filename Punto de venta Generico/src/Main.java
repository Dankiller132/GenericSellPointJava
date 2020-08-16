import java.util.*;

import javax.swing.AbstractListModel;
import javax.swing.JList;

import java.io.*;
//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import ProductsTypes.GenericFoodType;
public class Main {

	static ArrayList<GenericFoodType> GFoodList;
	
	
	public static void main(String[] args) {
		
		
		GFoodList= new ArrayList<GenericFoodType>();
		//GFoodList=
				GetList();		
		if(GFoodList.size()>0) {for(int x=0;x<GFoodList.size();x++) {GFoodList.get(x).flag=x;}}		
		String[] nNames= new String[GFoodList.size()];
		for (int x=0; x<GFoodList.size();x++)
		{nNames[x]=GFoodList.get(x).Nombre;
		 System.out.println(nNames[x]);}
		
MainJFrame.main(nNames);

	}
	public static String[] NameList() {
		String[] Final=new String[GFoodList.size()];
		int x=GFoodList.size();
		for(int g =0;g<x;g++) {
			   Final[g]=GFoodList.get(g).Nombre;
		   }
		
		
		return Final;
	}
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public static String[] QuantityList() {
		String[] Final=new String[GFoodList.size()];
		int x=GFoodList.size();
		for(int g =0;g<x;g++) {
			   Final[g]=Integer.toString(GFoodList.get(g).Quantity);
		   }
		
		
		return Final;
	}
    public static String[] LastSellList() {
		String[] Final=new String[GFoodList.size()];
		int x=GFoodList.size();
		for(int g =0;g<x;g++) {
			   Final[g]= Integer.toString(GFoodList.get(g).LastSell);
		   }
		
		
		return Final;
	}
public static void AddProduct(GenericFoodType NewObject) {
	
	GFoodList.add(NewObject);
	   LinkedHashSet<GenericFoodType> newlist = new LinkedHashSet<GenericFoodType>();
	   newlist.addAll(GFoodList);
	   GFoodList.clear();
	   GFoodList.addAll(newlist);
	   int x=GFoodList.size();
	   String[] NameList=NameList();
	   //MainJFrame.contentpane
	   //MainJFrame.main(NameList);
	   
	   String[] values;
		if(NameList.length==0) { values = new String[] {"None"};}
		else {values=NameList; }
		//MainJFrame.list = new JList();
		MainJFrame.NameList.setModel(new AbstractListModel() {
			String[] D=values;
			public int getSize() {
				return D.length;
			}
			public Object getElementAt(int index) {
				return D[index];
			}
		});
	   
	   //MainJFrame.list;

	   }		
	public static String DeleteProduct(int x) {
		if(GFoodList.size()>0){	
			GenericFoodType ob= GFoodList.get(x);
	if(GFoodList.contains(ob)) {
		GFoodList.remove(ob);
		if(GFoodList.size()<1) {return "Product List is Empty";}
		return "Product"+ob.Nombre+" Removed";
	}
	return (ob.Nombre+"not found");
	}
		else {
			return "Nothing in Storage";
		}
   }
	public static String GetSelected(int x) {
	
		if(GFoodList.size()==0) {return "List is Empty";}
		GenericFoodType Actual=GFoodList.get(x);
	return (
			Actual.Nombre+", "+Actual.Description+
			" BuyCost:"+Actual.BuyCost+", In storage:"+Actual.Quantity
			+", SellPrice:"+Actual.PriceF+", Tax:"+Actual.PriceIVA+", Gain per product: "+Actual.AverageIncome 
						);
}
    static void SaveList() {
    	
    	try {
            FileOutputStream fileOut =
            new FileOutputStream("/tmp/Supertanaka.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(GFoodList);
            out.close();
            fileOut.close();
            
         } catch (IOException i) {
            i.printStackTrace();
         }
    	
    }
    @SuppressWarnings("unchecked")
	static ArrayList<GenericFoodType> GetList() {
    	ArrayList<GenericFoodType> F= new ArrayList<GenericFoodType>();
	  try {
	         FileInputStream fileIn = new FileInputStream("/tmp/Supertanaka.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         F= (ArrayList<GenericFoodType>) in.readObject();
	         in.close();
	         fileIn.close();	         
	         return F;
	      }
	  catch (FileNotFoundException i) {
		  SaveList();
	    	  return F;
	      }
	  catch (IOException i) {
	         i.printStackTrace();
	         return F;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Previus List Not Found");
	         c.printStackTrace();
	         return F;
	      }
  }
}
