package logic;

import java.util.ArrayList;

public class Building {
	private ArrayList<EnterProfile> enterProfileList;

	private int populationCount = 0;
	private int potentialInfectedCount = 0;
	
	public Building() {
		enterProfileList = new ArrayList<EnterProfile>();
	}

	public EnterProfile addProfile(Person person, int temperature) {
		EnterProfile profile = new EnterProfile(person, temperature);

		// Using equals() for object equality comparison
		for (EnterProfile p : enterProfileList) {
			if (p.getPerson().equals(person)) {
				if (p.hasFever()) potentialInfectedCount--;
				enterProfileList.remove(p);
				populationCount--;
				break;
			}
		}

		if (profile.hasFever()) potentialInfectedCount++;
		populationCount++;
		enterProfileList.add(profile);

		return profile;
	}
	
	
	public EnterProfile removeProfile(int index) {
		//Fill Code Here
		EnterProfile profile = enterProfileList.get(index);

		enterProfileList.remove(profile);

		if (profile.hasFever()) --potentialInfectedCount;
		--populationCount;

		return profile;
	}
	


	public int getPopulationCount() {
		return populationCount;
	}

 

	public int getPotentialInfectedCount() {
		return potentialInfectedCount;
	}

	public ArrayList<EnterProfile> getEnterProfileList() {
		return enterProfileList;
	}
}
