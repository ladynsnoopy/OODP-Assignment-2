package view;

public class DisplayPageAb implements DisplayPage {
	
	public DisplayPageAb() {
		super();
	}

	public void enterToReturn() {
		System.out.println("Press enter to return\n"); // general function required for all display pages
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}
}
