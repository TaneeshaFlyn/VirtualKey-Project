package Service;

import Screen.options;
import Screen.screen;
import Screen.Welcome;
import Directory.directorys;


public class screen {

	//Directory dir = new Directory();



	public static welcome welcome = new welcome();
    public static options options = new options();



    public static screen CurrentScreen = welcome;


    public static screen getCurrentScreen() {
        return CurrentScreen;
    }


    public static void setCurrentScreen(screen currentScreen) {
        CurrentScreen = currentScreen;
    }


}
