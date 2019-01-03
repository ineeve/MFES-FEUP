package cli;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public abstract class Menu {

	private Scanner scanner = new Scanner(System.in);
	
	private Integer newOptionId = 1;
	private TreeMap<Integer, String> optionsStrings = new TreeMap<>();
	private HashMap<Integer, Runnable> optionsActions = new HashMap<>();
	
	protected void addOption(String description, Runnable action) {
		optionsStrings.put(newOptionId, description);
		optionsActions.put(newOptionId, action);
		newOptionId++;
	}
	
	private boolean isValidOption(Integer optionId) {
		return optionId >= 0 && optionId <= optionsStrings.size();
	}
	
	private void executeOption(Integer id) throws GoBackException {
		if (isBackOption(id)) {
			throw new GoBackException();
		}
		optionsActions.get(id).run();
	}
	
	private boolean isBackOption(Integer id) {
		return id == 0;
	}

	private void presentOptions() {
		System.out.println("Options:");
		System.out.println(" 0- Back");
		for (Map.Entry<Integer, String> entry : optionsStrings.entrySet()) {
		     System.out.println(" " + entry.getKey() + "- " + entry.getValue());
		}
	}
	
	private void pickOption() throws GoBackException {
		System.out.println("Pick an option: ");
		Integer option = scanner.nextInt();
		if (isValidOption(option)) {
			executeOption(option);
		} else {
			System.out.println("Invalid option, please pick another.");
		}
		System.out.println();
	}
	
	private void loop() {
		try {
			while (true) {
				presentOptions();
				pickOption();
			}
		} catch (GoBackException e) {}
	}
	
	public Menu() {
		initialize();
		loop();
	}
	
	/**
	 * Responsible for adding options to the desired menu.
	 */
	public abstract void initialize();
}
