package com.cooksys.butterpillar.model.impl;

import com.cooksys.butterpillar.model.IButterpillar;
import com.cooksys.butterpillar.model.ICatterfly;
import com.cooksys.butterpillar.model.IGrowthModel;
import com.cooksys.butterpillar.model.ISpecies;

public class Species implements ISpecies{
	private String name;
	private IGrowthModel growthModel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IGrowthModel getGrowthModel() {
		return growthModel;
	}

	public void setGrowthModel(IGrowthModel growthModel) {
		this.growthModel = growthModel;
	}

	public ICatterfly createCatterfly(double wingspan, double weight) {
		ICatterfly c = new Catterfly();

		c.setWeight(weight);
		c.setWingspan(wingspan);
		return c;

	}

	public IButterpillar createButterpillar(double length, double leavesEaten) {
		IButterpillar b = new Butterpillar();
		b.setLength(length);
		b.setLeavesEaten(leavesEaten);
		return b;
	}

	public ICatterfly[] convert(IButterpillar[] butterpillars) {
		ICatterfly[] catterflies = new ICatterfly[butterpillars.length];

		for (int i = 0; i < butterpillars.length; i++) {
			catterflies[i] = growthModel.butterpillarToCatterfly(butterpillars[i]);
		}

		return catterflies;

	}

	public IButterpillar[] convert(ICatterfly[] catterflies) {
		IButterpillar[] butterpillars = new IButterpillar[catterflies.length];

		for (int i = 0; i < catterflies.length; i++) {
			butterpillars[i] = growthModel.catterflyToButterpillar(catterflies[i]);
		}

		return butterpillars;

	}
}
