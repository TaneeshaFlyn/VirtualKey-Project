package Service;

import Screen.options;
import Screen.interfaces;
import Screen.Welcome; 
import Index.directorys;

public class screens {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

	public static Welcome Welcome = new Welcome();
    public static options options = new options();


    public static interfaces CurrentScreen = Welcome;


    public static void setCurrentScreen(interfaces currentScreen) {
        CurrentScreen = currentScreen;
    }


    public static interfaces getCurrentScreen() {
        return CurrentScreen;
    }


    public static void setCurrentScreen(options currentScreen) {
        CurrentScreen = currentScreen;
    }
}