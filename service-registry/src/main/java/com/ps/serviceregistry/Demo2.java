package com.ps.serviceregistry;

import java.util.Arrays;
import java.util.List;

import com.netflix.servo.util.Strings;

public class Demo2 {

	public List<List<String>> getAnGroups (List<String> words) {

		
		//List<List<Strings>>  a;
		
		
		
	   String[] wordsArray= words.toArray();
		
	
	   for (int i=0; i<words.size();i++) {
		   for (int j=i+1; i<words.size();j++) {
		
			   if(isAnagram())
				   
			   {
				   //list2 
			   }
			   
				   
		   }
		   
		   
	   }
	   
	   
		
		return null;

	}
	
	// [  ]
			 
	"tan","ate","nat","bat"
	
	
		//	+ "
		//	tan = 1
	
	
//	["","","tan","ate","nat","bat"]
			
//	 put in list - eat	tea	
	
	
	
			//eat,tea =true
			
			//listb.add(s1)
			//listb.add(s2)
			
			

	public boolean isAnagram(String s1, String s2) {

		boolean isAnagram = false;

		if (s1.length() != s2.length()) {
			return false;
		} else {
			char[] c1 = s1.toCharArray();
			char[] c2 = s2.toCharArray();

			Arrays.sort(c1);
			Arrays.sort(c2);

			if (c1.equals(c2)) {
				isAnagram = true;
			}
		}

		return isAnagram;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Input: strs = ["eat","tea","tan","ate","nat","bat"]Output:
		// [["bat"],["nat","tan"],["ate","eat","tea"]]

		// list of strings
		// boat toab input
		// oatb
		// groups anagrams

		// grapes

		// list list<string>
		// boat toab oatb eat

	}

}
