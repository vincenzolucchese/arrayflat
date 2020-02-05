package com.demo.arrayflat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AppFlatArray {

	private static final String ARRAY_START = "[";
	private static final String ARRAY_END = "]";
	private static final String ELEMENT_DELIMIT = ",";
	private static String matrixDemo = "[0  ,[1,2,[3]],4777,[5,[6,[7,[8,[889]]]]]";

	public static ArrayList<Integer> arrayFlat = null;
	static TreeMap<String, Integer> mapMatrix = null;
	static String indexes = "0";
	static int cursor = 0;
	static int dimension = 0;

	public static void main(String[] args) {
		//init for multi tests
		indexes = "0";
		cursor = 0;
		dimension = 0;
		mapMatrix = new TreeMap<String, Integer>();
		arrayFlat = new ArrayList<Integer>();
		
		if (args != null && args.length == 1 && args[0] != null) {
			matrixDemo="";
			System.out.println("Input args:" + args.toString());
			matrixDemo = args[0];
		}else {
			//default value for matrixDemo
			matrixDemo = "[[1,2,[3]],4]}";
		}
		matrixDemo=matrixDemo.replaceAll("\\s", "");
		System.out.println("Matrix to flats:" + matrixDemo);
		readDimension();
		createIndexZero();
		createMatrix();
		writeFoFlatArray();
	}

	private static void writeFoFlatArray() {
		for (Map.Entry<String, Integer> each : mapMatrix.entrySet()) {
			arrayFlat.add(each.getValue());
		}
		System.out.println("arrayFlat: " + arrayFlat);
	}

	private static void createMatrix() {
		for (int i = 1; i <= matrixDemo.length() - 2; i++) {
			System.out.println("Read char posix:" + i + " : " + matrixDemo.charAt(i));
			String charReaded = "" + matrixDemo.charAt(i);
			if (ARRAY_START.equals(charReaded)) {
				cursor++;
			} else if (ARRAY_END.equals(charReaded)) {
				cursor--;
			} else if (ELEMENT_DELIMIT.equals(charReaded)) {
				incrementPosix();
			} else {
				int j=i;
				while(Character.isDigit(matrixDemo.charAt(j+1))) {
					j++;
					charReaded=charReaded+""+ matrixDemo.charAt(j);					
				}
				i=j;
				Integer e = new Integer(charReaded);
				mapMatrix.put(indexes, e);
			}
			System.out.println("mapMatrix:" + mapMatrix);
		}
	}

	private static void incrementPosix() {
		List<String> arrayIndex = Arrays.asList(indexes.split("-"));
		String temp = arrayIndex.get(cursor);
		int i = new Integer(temp);
		i++;
		temp = Integer.toString(i);
		arrayIndex.set(cursor, temp);
		indexes = "";
		for (String each : arrayIndex) {
			if (!indexes.equals("")) {
				indexes = indexes + "-";
			}
			indexes = indexes + each;
		}
	}

	private static void createIndexZero() {
		int i = 1;
		while (i < dimension) {
			indexes = indexes + "-0";
			i++;
		}
		System.out.println("indexe zero:" + indexes);
	}

	private static void readDimension() {
		String demo = matrixDemo.replaceAll(",", "");
		demo = demo.replaceAll("[0-9]", "");
		int temp = 0;
		for (int i = 0; i <= demo.length() - 1; i++) {
			String charReaded = "" + demo.charAt(i);
			if (ARRAY_START.equals(charReaded)) {
				dimension++;
				if (dimension > temp) {
					temp = dimension;
				}
			} else
				dimension--;
		}
		dimension = temp;
		System.out.println("dimension:" + dimension);
	}

}
