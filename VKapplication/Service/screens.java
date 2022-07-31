package Service;

import Screen.options;
import Screen.screen;
import Screen.Welcome;
import Directory.directorys;


public class screens {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

	//Directory dir = new Directory();



	public static welcome welcome = new welcome();
    public static options options = new options();



    public static screens CurrentScreen = welcome;


    public static screens getCurrentScreen() {
        return CurrentScreen;
    }


    public static void setCurrentScreen(screens currentScreen) {
        CurrentScreen = currentScreen;
    }


}
