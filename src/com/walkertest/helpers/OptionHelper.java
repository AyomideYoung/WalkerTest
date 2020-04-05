package com.walkertest.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.walkertest.question.Option;

public class OptionHelper {

	 public static <K, V> Option<K, V> createOption(K id,V value) {
		 Option<K, V> data = new Option<>();
		 data.setLabel(id);
		 data.setData(value);
		 return data;
	 }
	 
	 public static <K, V> Set<Option<K, V>> createOptionSet(List<K> ids, List<V> values){
		if(ids.size() != values.size())
			throw new IllegalArgumentException("The given lists are not equal in length");
		 
		Set<Option<K, V>> resultSet = new HashSet<>();
		for(int i = 0;i < ids.size(); i++) {
			Option<K, V> idData = createOption(ids.get(i), values.get(i));
			resultSet.add(idData);
		}
		
		return resultSet;
	 }
	 
	
	 
	 public static <V> Set<Option<Integer, V>> createOptionSetWithNumericalLabel(Set<V> values){
		 int[] numericalLabels = OrderedAlphanumericGenerator.generateNumbersFromAMinimum(1, values.size());
		 List<Integer> numericalLabelsList =  intArrayToIntegerList(numericalLabels);
		 List<V> valuesList = setToList(values);
		 
		 return createOptionSet(numericalLabelsList, valuesList);
	 }
	 
	 private static List<Integer> intArrayToIntegerList(int[] array){
		 List<Integer> list = new ArrayList<>();
		 for(int x: array)
			 list.add(x);
		 return list;
	 }
	 
	 private static <V> List<V> setToList(Set<V> set){
		 return set.stream().collect(Collectors.toList());
	 }
	 
	 public static <V> Set<Option<String, V>> createOptionSetWithAlphabeticalLabel(Set<V> values){
		 String[] labelsArray = OrderedAlphanumericGenerator.generateAlphabets(values.size());
		 List<String> labelsList = Arrays.asList(labelsArray);
		 List<V> valuesList = setToList(values);
		 
		 return createOptionSet(labelsList, valuesList);
	 }
}
