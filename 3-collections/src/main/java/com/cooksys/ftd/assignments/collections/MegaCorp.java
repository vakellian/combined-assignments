package com.cooksys.ftd.assignments.collections;

import com.cooksys.ftd.assignments.collections.hierarchy.Hierarchy;
import com.cooksys.ftd.assignments.collections.model.Capitalist;
import com.cooksys.ftd.assignments.collections.model.FatCat;
import com.cooksys.ftd.assignments.collections.model.WageSlave;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class MegaCorp implements Hierarchy<Capitalist, FatCat> {

	Set<Capitalist> set = new HashSet<>();
	
	List<FatCat> list = new ArrayList<>();
	
    /**
     * Adds a given element to the hierarchy.
     * <p>
     * If the given element is already present in the hierarchy,
     * do not add it and return false
     * <p>
     * If the given element has a parent and the parent is not part of the hierarchy,
     * add the parent and then add the given element
     * <p>
     * If the given element has no parent but is a Parent itself,
     * add it to the hierarchy
     * <p>
     * If the given element has no parent and is not a Parent itself,
     * do not add it and return false
     *
     * @param capitalist the element to add to the hierarchy
     * @return true if the element was added successfully, false otherwise
     */
    @Override
    public boolean add(Capitalist capitalist) {
        if(set.contains(capitalist) || capitalist == null)
        	return false;
        
        if(capitalist.hasParent() && !set.contains(capitalist)) {        	
        	add(capitalist.getParent());        	
        	return set.add(capitalist);
        }
        
        if(!capitalist.hasParent() && capitalist instanceof FatCat) {
        	return set.add(capitalist);
        }
        
        if(!capitalist.hasParent() && capitalist instanceof WageSlave)
        	return false;
        
        return true;
    }

    /**
     * @param capitalist the element to search for
     * @return true if the element has been added to the hierarchy, false otherwise
     */
    @Override
    public boolean has(Capitalist capitalist) {
        if(set.contains(capitalist))
        	return true;
        
        return false;
    }

    /**
     * @return all elements in the hierarchy,
     * or an empty set if no elements have been added to the hierarchy
     */
    @Override
    public Set<Capitalist> getElements() {
    	Set<Capitalist> elements = new HashSet<>();      
    	for(Capitalist cap : set) {
        	elements.add(cap);
        }
    	return elements;
    }

    /**
     * @return all parent elements in the hierarchy,
     * or an empty set if no parents have been added to the hierarchy
     */
    @Override
    public Set<FatCat> getParents() {
        Set<FatCat> fatCatSet = new HashSet<>();
        for(Capitalist cap : set) {
        	if(cap instanceof FatCat)
        		fatCatSet.add((FatCat) cap);
        }
        
        return fatCatSet;
    }

    /**
     * @param fatCat the parent whose children need to be returned
     * @return all elements in the hierarchy that have the given parent as a direct parent,
     * or an empty set if the parent is not present in the hierarchy or if there are no children
     * for the given parent
     */
    @Override
    public Set<Capitalist> getChildren(FatCat fatCat) {
        Set<Capitalist> childSet = new HashSet<>();
        Capitalist cap, newCap;
        
        if(fatCat == null) {
        	return childSet;
        }
        
        
        if(!set.contains(fatCat)) {
        	return childSet;
        }
        
        Iterator<Capitalist> it = set.iterator();
        while(it.hasNext()){
        	cap = it.next();
        	
        	if(cap.hasParent() && cap.getParent().equals(fatCat)) {
        		if(cap instanceof FatCat) {
        			newCap = new FatCat(cap.getName(), cap.getSalary(), fatCat);
        		} else {
        			newCap = new WageSlave(cap.getName(), cap.getSalary(), fatCat);
        		}
        		childSet.add(newCap.clone());
        	}
        }
        return childSet;
    }

    /**
     * @return a map in which the keys represent the parent elements in the hierarchy,
     * and the each value is a set of the direct children of the associate parent, or an
     * empty map if the hierarchy is empty.
     */
    @Override
    public Map<FatCat, Set<Capitalist>> getHierarchy() {
        Map<FatCat, Set<Capitalist>> newMap = new HashMap<>();
        Set<FatCat> parents = getParents();
        
        for(FatCat fc : parents) {
        	
        	newMap.put(fc.clone(), getChildren(fc) );        	
        }
        return newMap;
    }

    /**
     * @param capitalist
     * @return the parent chain of the given element, starting with its direct parent,
     * then its parent's parent, etc, or an empty list if the given element has no parent
     * or if its parent is not in the hierarchy
     */
    @Override
    public List<FatCat> getParentChain(Capitalist capitalist) {
        List<FatCat> list = new ArrayList<>();
        if(capitalist == null)
        	return list;
        
        FatCat parent;
        
        while(capitalist != null && capitalist.hasParent()) {
        	parent = capitalist.getParent();
        	if(has(parent)) {
        		list.add(parent.clone());
        	}
        	capitalist = parent;
        }        	
        
        return list;
    }
	    
}
