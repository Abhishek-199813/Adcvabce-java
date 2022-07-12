package cdac.webprojectday2;

import java.util.*;
public class One {
	   public static void main(String args[]) {
	      // create hash set
	      Set<Integer> hs = new HashSet<Integer>();
	      hs.add(10);
	      hs.add(20);
	      hs.add(30);
	      hs.add(40);
	      hs.add(50);
	      
	      System.out.println("Elements in set = "+hs);
	      
	      if(hs.contains(30))
	      {
	      System.out.println("30 is present in the set");
	      }
	      else
	      {
	    	  System.out.println("30 is present in the set");
	      }
	   }
	}